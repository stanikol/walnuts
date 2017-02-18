package controllers.nuts

/**
 * Created by stanikol on 1/29/17.
 */

import java.io.{ BufferedInputStream, FileInputStream, FileOutputStream }
import javax.inject._

import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.nuts.Data.Article
import models.nuts.Tables._
import models.nuts.FormsData._
import play.api.i18n.{ I18nSupport, Messages }
import play.api.libs.json.JsValue
import slick.driver.PostgresDriver.api._
import utils.auth.{ Access, WithRole }
//import models.nuts.MyPostgresDriver.api._
import play.api.mvc._
import play.api.Logger
import play.api.cache.{ CacheApi, Cached }
import play.api.data._
import play.api.data.Forms._
import play.api.libs.concurrent.Execution.Implicits._
import com.sksamuel.scrimage.{ Image => Img }
import models.nuts.Data.{ Image, ImageInfo }
import net.sf.ehcache.{ CacheManager, Ehcache }
import play.api.i18n.MessagesApi
import play.api.libs.json.Json
import play.filters.csrf.CSRF
import play.filters.csrf.CSRF.Token
import play.twirl.api.Html
import utils.auth.DefaultEnv

import scala.concurrent.Future

class Blog @Inject() (
    db: models.nuts.DBService,
    //         cached: Cached,
    //         cacheMan: CacheManager,
    silhouette: Silhouette[DefaultEnv],
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets
) extends Controller with I18nSupport {

  def showAllArticles = silhouette.UserAwareAction.async { implicit request =>
    db.runAsync(articles.sortBy(_.sort_order.desc).result).map { articles =>
      Ok(views.html.blog.listArticles(request.identity, articles))
    }
    //    Future(Ok(""))
  }

  def article(id: Long) = silhouette.UserAwareAction.async { implicit request =>
    Logger.error(s"Article $id")
    db.runAsync(articles.filter(_.id === id).result.head).map(article =>
      Ok(views.html.blog.showArticle(request.identity, article)))
  }

  def create() = silhouette.SecuredAction(Access("admin")) { implicit request =>
    Ok(views.html.blog.editArticle(request.identity, articleForm.fill(Article.empty)))
  }

  def edit(id: Long) = silhouette.SecuredAction(Access("admin")).async { implicit request =>
    db.runAsync(articles.filter(_.id === id).result.headOption).map {
      case someArticle @ Some(article) =>
        Ok(views.html.blog.editArticle(request.identity, articleForm.fill(article)))
      case _ =>
        Ok(views.html.blog.editArticle(request.identity, articleForm.fill(Article.empty),
          Map("id" -> Messages("editArticle.not-found").format(id))))
    }
  }

  def onSubmit() = silhouette.SecuredAction(Access("admin")).async { implicit request =>
    val action: Seq[String] = request.body.asFormUrlEncoded.get("action")
    articleForm.bindFromRequest().fold(
      errorForm => {
        val id = errorForm.data.getOrElse("id", None)
        val errors: Map[String, String] = errorForm.errors.map(formError => formError.key -> formError.messages.map(Messages(_)).mkString(",")).toMap
        //        var errorMsg = "Invalid data %s action=%s ! %s".format(error.data, action, errors)
        //        Logger.error(errorMsg)
        Future(Ok(views.html.blog.editArticle(request.identity, errorForm, errors)))
      },
      article => {
        Logger.info(s"Going to ${action.head} $article ...")
        action match {
          case Seq("new") =>
            db.runAsync(insertArticle += article).map { newArticle =>
              val id = newArticle.id.get //OrElse(newArticle)
              Redirect(controllers.nuts.routes.Blog.article(id))
                .flashing("success" -> Messages("New article #%s is created.").format(id))
            }
          case Seq("save") if article.id.isDefined =>
            db.runAsync(articles.filter(_.id === article.id).update(article)).map { updatedRows =>
              val id = article.id.get
              if (updatedRows == 1)
                Redirect(controllers.nuts.routes.Blog.article(id))
                  .flashing("success" -> Messages("New article #%s is updated.").format(id))
              else
                Redirect(controllers.nuts.routes.Blog.article(id))
                  .flashing("error" -> Messages("Error while updating article #%s!").format(id))
            }
          case Seq("delete") if article.id.isDefined =>
            Logger.warn(s"Going to delete article ${article.id.get} ...")
            db.runAsync(articles.filter(_.id === article.id.get).delete).map { rowsDeleted =>
              if (rowsDeleted >= 1) {
                val msg = Messages("editArticle.article-deleted").format(rowsDeleted, article.id.get)
                Logger.warn(msg)
                Redirect(controllers.nuts.routes.Blog.showAllArticles).flashing("success" -> msg)
              } else {
                val errorMsg = Messages("editArticle.article-delete-failed").format(article.id.get)
                Redirect(controllers.nuts.routes.Blog.showAllArticles).flashing("error" -> errorMsg)
              }
            }
          case unknown =>
            val errorMsg = Messages("blog.unknown-command").format(unknown.toString(), article.id.getOrElse("None"))
            Logger.error(errorMsg)
            Future(Redirect(controllers.nuts.routes.Blog.edit(article.id.get)).flashing("error" -> errorMsg))
        }
      }
    )
  }
}

