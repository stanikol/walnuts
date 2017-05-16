package controllers.blog

/**
 * Created by stanikol on 1/29/17.
 */

import javax.inject._

import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import controllers.blog.FormsData._
import models.blog.{ BlogDAO, CommentInfo, CommentsDAO, CommentsShow }
import play.api.Configuration
import play.api.i18n.{ I18nSupport, Messages, MessagesApi }
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.mailer.{ Email, MailerClient }
import play.api.mvc._
import utils.auth.{ DefaultEnv, Roles }

import scala.concurrent.Future

class Comments @Inject() (
    blogDAO: BlogDAO,
    commentsDAO: CommentsDAO,
    silhouette: Silhouette[DefaultEnv],
    val messagesApi: MessagesApi,
    mailerClient: MailerClient,
    configuration: Configuration,
    implicit val webJarAssets: WebJarAssets
) extends Controller with I18nSupport {

  val sendCommentsToEmail = configuration.getString("email.sendCommentsTo").get

  /**
   * Adds comment to DB. If user isn't signed in, it pushes current url in `returnUrl` session cookie,
   * so that after signin (signup) process, user could be redirected to the url.
   * @return
   */
  def addComment = silhouette.UserAwareAction.async { implicit request =>
    val badRequest = Future(BadRequest(Messages("Error! Either invalid form data or authorised user request.")))
    addCommentForm.bindFromRequest().fold(
      { error => badRequest },
      { ok: AddComment =>
        request.identity.map { userIdentity =>
          ok.comment match {
            case Some(text) =>
              commentsDAO.newComment(ok.articleID, text, userIdentity).map { _ =>
                ok.comment.map { comment =>
                  mailerClient.send(Email(
                    subject = Messages("email.newComment"),
                    from = Messages("email.from"),
                    to = Seq(sendCommentsToEmail),
                    bodyText = Some(s"$ok $comment"),
                    bodyHtml = None
                  ))
                }
                Redirect(controllers.blog.routes.Blog.article(ok.articleID))
                  .flashing("success" -> Messages("Your comment is successfully added."))
              }
            case None =>
              Future(Redirect(controllers.blog.routes.Blog.article(ok.articleID))
                .flashing("error" -> Messages("Nothing to add!")))
          }
        }.getOrElse {
          var returnUrl = controllers.blog.routes.Blog.article(ok.articleID).absoluteURL()
          Future(Redirect(controllers.auth.routes.SignInController.view)
            .withSession(("returnUrl", returnUrl))
            .flashing("error" -> Messages("Nothing to add!")))
        }
      }
    )
  }

  /**
   * Offers user to login or signup.
   * @return
   */
  def loginOrSignUp = silhouette.UserAwareAction.async { implicit request =>
    Future(Ok(views.html.blog.loginOrSignUp(request.identity)))
  }

  def deleteOrUpdateComment = silhouette.SecuredAction(Roles.Admin).async { implicit req =>
    editCommentForm.bindFromRequest().fold(
      { error => Future(Redirect(controllers.blog.routes.Comments.commentsAdmin()).flashing("error" -> s"Error $error")) },
      { editComment =>
        editComment.action match {
          case "del" =>
            commentsDAO.deleteComment(editComment.commentID).map { _ =>
              Redirect(controllers.blog.routes.Comments.commentsAdmin()).flashing("success" -> s"Comment #${editComment.commentID} is deleted.")
            }
          case "upd" =>
            commentsDAO.updateCommentText(editComment.commentID, editComment.commentText).map { _ =>
              Redirect(controllers.blog.routes.Comments.commentsAdmin()).flashing("success" -> s"Text of the comment #${editComment.commentID} is updated.")
            }
          case unknown =>
            Future(
              Redirect(controllers.blog.routes.Comments.commentsAdmin())
                .flashing("error" -> s"Unknown action `$unknown` for comment #${editComment.commentID} !")
            )
        }
      }
    )
  }

  def commentsAdmin = silhouette.SecuredAction(Roles.Admin).async { implicit req =>
    commentsShowForm.bindFromRequest().fold(
      { error =>
        Future(Redirect(controllers.blog.routes.Comments.commentsAdmin())
          .flashing("error" -> error.errors.mkString("; ")))
      },
      { commentsShow: CommentsShow =>
        commentsDAO.listAll(commentsShow).map {
          comments: Seq[CommentInfo] =>
            Ok(views.html.blog.commentsEdit(req.identity, comments, commentsShowForm.fill(commentsShow)))
        }
      }
    )
  }

}

