package controllers.blog

/**
 */

import javax.inject._

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import controllers.blog.FormsData._
import models.blog.{ Article, BlogDAO, CommentsDAO }
import models.pages.PagesDAO
import play.api.data.Form
import play.api.i18n.{ I18nSupport, Lang, Messages, MessagesApi }
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.mailer.MailerClient
import play.api.mvc._
import play.api.{ Configuration, Logger }
import utils.auth.DefaultEnv
import utils.auth.Roles.Admin

import scala.concurrent.Future

class BlogAdmin @Inject() (
    blogDAO: BlogDAO,
    pagesDAO: PagesDAO,
    commentsDAO: CommentsDAO,
    mailerClient: MailerClient,
    silhouette: Silhouette[DefaultEnv],
    config: Configuration,
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets,
    implicit val mat: Materializer
) extends Controller with I18nSupport {

  val onSubmitMaxMemoryBuffer: Int = config.getBytes("blogOnSubmitMaxMemoryBuffer").getOrElse(512 * 1024L).asInstanceOf[Int]

  import blogDAO._

  def create() = silhouette.SecuredAction(Admin) { implicit request =>
    Ok(views.html.blog.adminBlog(request.identity, articleForm.fill(Article.empty)))
  }

  //  import play.api.d
  //  val pageForm = Form(mapping())
  def showAdminBlog(id: Long) = silhouette.SecuredAction(Admin).async { implicit request =>
    getArticle(id).map {
      case Some(article) =>
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
              Redirect(controllers.blog.routes.Blog.article(id))
                .flashing("success" -> Messages("blog.article-created", id))
            }
          case Some("save") if article.id.isDefined =>
            updateArticle(article).map { updatedRows =>
              val id = article.id.get
              if (updatedRows == 1)
                Redirect(controllers.blog.routes.Blog.article(id))
                  .flashing("success" -> Messages("blog.article-updated", id))
              else
                Redirect(controllers.blog.routes.Blog.article(id))
                  .flashing("error" -> Messages("blog.article-updateGoodsItem-error", id))
            }
          case Some("delete") if article.id.isDefined =>
            Logger.warn(s"Going to deleteGoodsItem article ${article.id.get} ...")
            deleteArticle(article.id.get).map { rowsDeleted =>
              if (rowsDeleted >= 1) {
                val msg = Messages("blog.article-deleted").format(rowsDeleted, article.id.get)
                Logger.warn(msg)
                Redirect(controllers.blog.routes.Blog.showAllArticles).flashing("success" -> msg)
              } else {
                val errorMsg = Messages("blog.article-deleteGoodsItem-failed", article.id.get)
                Redirect(controllers.blog.routes.Blog.showAllArticles).flashing("error" -> errorMsg)
              }
            }
          case unknown =>
            val errorMsg = Messages("blog.unknown-command", unknown.toString(), article.id.getOrElse("None"))
            Logger.error(errorMsg)
            Future(Redirect(controllers.blog.routes.BlogAdmin.showAdminBlog(article.id.get)).flashing("error" -> errorMsg))
        }
      }
    )
  }
}

