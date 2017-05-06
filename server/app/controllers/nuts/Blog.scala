package controllers.nuts

/**
 * Created by stanikol on 1/29/17.
 */

import javax.inject._

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.blog.{ BlogDAO, CommentsDAO }
import models.blog.Data.{ Article, Comment, CommentInfo }
import models.blog.FormsData._
import play.api.i18n.{ I18nSupport, Messages }
import utils.auth.Roles.Admin
import play.api.{ Configuration, Logger }
import play.api.i18n.MessagesApi
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.mailer.MailerClient
import play.api.mvc._
import utils.auth.DefaultEnv

import scala.concurrent.Future

class Blog @Inject() (
    blogDAO: BlogDAO,
    commentsDAO: CommentsDAO,
    mailerClient: MailerClient,
    silhouette: Silhouette[DefaultEnv],
    config: Configuration,
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets,
    implicit val mat: Materializer
) extends Controller with I18nSupport {

  val onSubmitMaxMemoryBuffer: Int = config.getBytes("blogOnSubmitMaxMemoryBuffer").getOrElse(512 * 1024L).asInstanceOf[Int]

  import blogDAO._, commentsDAO._

  def showAllArticles = silhouette.UserAwareAction.async { implicit request =>
    getAllArticles.map { articles =>
      Ok(views.html.blog.blogList(request.identity, articles))
    }
  }

  def article(id: Long) = silhouette.UserAwareAction.async { implicit request =>
    Logger.debug("Retrieving article #%d ...".format(id))
    val articleWithComments: Future[Tuple2[Option[Article], Seq[CommentInfo]]] =
      for (
        a <- getArticle(id);
        c <- getComments(a.get.id.get) if a.isDefined
      ) yield (a, c)
    articleWithComments map {
      case (Some(article), comments) =>
        Ok(views.html.blog.blogShow(request.identity, article, comments))
      case _ => BadRequest(Messages("blog.not-found", id))
    }
  }

  def create() = silhouette.SecuredAction(Admin) { implicit request =>
    Ok(views.html.blog.adminBlog(request.identity, articleForm.fill(Article.empty)))
  }

  def edit(id: Long) = silhouette.SecuredAction(Admin).async { implicit request =>
    getArticle(id).map {
      case someArticle @ Some(article) =>
        Ok(views.html.blog.adminBlog(request.identity, articleForm.fill(article)))
      case _ =>
        Ok(views.html.blog.adminBlog(request.identity, articleForm.fill(Article.empty),
          Map("id" -> Messages("blog.not-found", id))))
    }
  }

  def onSubmit() = silhouette.SecuredAction(Admin).async(parse.urlFormEncoded(onSubmitMaxMemoryBuffer)) { implicit request =>
    //    val action: Seq[String] = request.body.asFormUrlEncoded.getGoodsItem("action")
    val action: Option[String] = actionForm.bindFromRequest().fold(
      _ => None, ok => ok
    )
    articleForm.bindFromRequest().fold(
      errorForm => {
        val id = errorForm.data.getOrElse("id", None)
        val errors: Map[String, String] = errorForm.errors.map(formError => formError.key -> formError.messages.map(Messages(_)).mkString(",")).toMap
        //        var errorMsg = "Invalid data %s action=%s ! %s".format(error.data, action, errors)
        //        Logger.error(errorMsg)
        Future(Ok(views.html.blog.adminBlog(request.identity, errorForm, errors)))
      },
      article => {
        Logger.info(s"Going to ${action.head} $article ...")
        action match {
          case Some("new") =>
            addNewArticle(article).map { newArticle =>
              val id = newArticle.id.get //OrElse(newArticle)
              Redirect(controllers.nuts.routes.Blog.article(id))
                .flashing("success" -> Messages("blog.article-created", id))
            }
          case Some("save") if article.id.isDefined =>
            updateArticle(article).map { updatedRows =>
              val id = article.id.get
              if (updatedRows == 1)
                Redirect(controllers.nuts.routes.Blog.article(id))
                  .flashing("success" -> Messages("blog.article-updated", id))
              else
                Redirect(controllers.nuts.routes.Blog.article(id))
                  .flashing("error" -> Messages("blog.article-updateGoodsItem-error", id))
            }
          case Some("delete") if article.id.isDefined =>
            Logger.warn(s"Going to deleteGoodsItem article ${article.id.get} ...")
            deleteArticle(article.id.get).map { rowsDeleted =>
              if (rowsDeleted >= 1) {
                val msg = Messages("blog.article-deleted").format(rowsDeleted, article.id.get)
                Logger.warn(msg)
                Redirect(controllers.nuts.routes.Blog.showAllArticles).flashing("success" -> msg)
              } else {
                val errorMsg = Messages("blog.article-deleteGoodsItem-failed", article.id.get)
                Redirect(controllers.nuts.routes.Blog.showAllArticles).flashing("error" -> errorMsg)
              }
            }
          case unknown =>
            val errorMsg = Messages("blog.unknown-command", unknown.toString(), article.id.getOrElse("None"))
            Logger.error(errorMsg)
            Future(Redirect(controllers.nuts.routes.Blog.edit(article.id.get)).flashing("error" -> errorMsg))
        }
      }
    )
  }
}

