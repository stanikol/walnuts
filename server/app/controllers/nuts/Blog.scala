package controllers.nuts

/**
 * Created by stanikol on 1/29/17.
 */

import javax.inject._

import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.nuts.{ BlogDAO, CommentsDAO }
import models.nuts.Data.{ Article, Comment }
import models.nuts.FormsData._
import models.nuts.Tables.Comments
import play.api.i18n.{ I18nSupport, Messages }
import utils.auth.Roles.Admin
import play.api.Logger
import play.api.i18n.MessagesApi
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc._
import utils.auth.DefaultEnv

import scala.concurrent.Future

class Blog @Inject() (
    blogDAO: BlogDAO,
    commentsDAO: CommentsDAO,
    silhouette: Silhouette[DefaultEnv],
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets
) extends Controller with I18nSupport {

  import blogDAO._, commentsDAO._

  def showAllArticles = silhouette.UserAwareAction.async { implicit request =>
    getAllArticles.map { articles =>
      Ok(views.html.blog.listArticles(request.identity, articles))
    }
  }

  def article(id: Long) = silhouette.UserAwareAction.async { implicit request =>
    Logger.info(Messages("Retrieving article #%d ...".format(id)))
    val articleWithComments: Future[Tuple2[Option[Article], Seq[Comment]]] =
      for (
        a <- getArticle(id);
        c <- getComments(a.get.id.get) if a.isDefined
      ) yield (a, c)
    articleWithComments map {
      case (Some(article), comments) => Ok(views.html.blog.showArticle(request.identity, article, comments))
      case _ => BadRequest(Messages(s"Article %d can not be found !".format(id)))
    }
  }

  def create() = silhouette.SecuredAction(Admin) { implicit request =>
    Ok(views.html.blog.editArticle(request.identity, articleForm.fill(Article.empty)))
  }

  def edit(id: Long) = silhouette.SecuredAction(Admin).async { implicit request =>
    getArticle(id).map {
      case someArticle @ Some(article) =>
        Ok(views.html.blog.editArticle(request.identity, articleForm.fill(article)))
      case _ =>
        Ok(views.html.blog.editArticle(request.identity, articleForm.fill(Article.empty),
          Map("id" -> Messages("editArticle.not-found").format(id))))
    }
  }

  def onSubmit() = silhouette.SecuredAction(Admin).async { implicit request =>
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
            addNewArticle(article).map { newArticle =>
              val id = newArticle.id.get //OrElse(newArticle)
              Redirect(controllers.nuts.routes.Blog.article(id))
                .flashing("success" -> Messages("New article #%s is created.").format(id))
            }
          case Seq("save") if article.id.isDefined =>
            updateArticle(article).map { updatedRows =>
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
            deleteArticle(article.id.get).map { rowsDeleted =>
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

