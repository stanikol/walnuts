package controllers.blog

/**
 * Created by stanikol on 1/29/17.
 */

import javax.inject._

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.blog._
import play.api.i18n.{ I18nSupport, Messages }
import play.api.{ Configuration, Logger }
import play.api.i18n.MessagesApi
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.mailer.MailerClient
import play.api.mvc._
import utils.auth.DefaultEnv

import scala.concurrent.{ ExecutionContext, Future }

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
    val articleWithComments: Future[Option[(Article, Seq[CommentInfo])]] =
      getArticle(id).flatMap { articleOpt =>
        articleOpt.map { article =>
          val id = article.id.getOrElse(0L)
          getComments(id).map { comments =>
            Some(article -> comments)
          }
        }.getOrElse(Future(None))
      }
    articleWithComments.map(
      _.map {
        case (article, comments) =>
          Ok(views.html.blog.showArticle(request.identity, article, comments))
      }.getOrElse {
        Redirect(controllers.blog.routes.Blog.showAllArticles()).flashing("error" -> Messages("blog.not-found", id))
      }
    )
    //    val articleWithComments: Future[Tuple2[Option[Article], Seq[CommentInfo]]] =
    //      for (
    //        a <- getArticle(id);
    //        c <- getComments(a.get.id.get) if a.get.id.isDefined
    //      ) yield (a, c)
    //    articleWithComments map {
    //      case (Some(article), comments) =>
    //        Ok(views.html.blog.showArticle(request.identity, article, comments))
    //      case _ => BadRequest(Messages("blog.not-found", id))
    //    }
  }

}

