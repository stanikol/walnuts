package controllers.pages

/**
 */

import javax.inject._

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import controllers.blog.FormsData._
import controllers.pages.FormsData.PageFormData
import models.blog.{ Article, BlogDAO, CommentsDAO }
import models.pages.PagesDAO
import play.api.i18n.{ I18nSupport, Lang, Messages, MessagesApi }
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.mailer.MailerClient
import play.api.mvc._
import play.api.{ Configuration, Logger }
import utils.auth.DefaultEnv
import utils.auth.Roles.Admin

import scala.concurrent.Future

class AdminPage @Inject() (
    pagesDAO: PagesDAO,
    mailerClient: MailerClient,
    silhouette: Silhouette[DefaultEnv],
    config: Configuration,
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets,
    implicit val mat: Materializer
) extends Controller with I18nSupport {

  val onSubmitMaxMemoryBuffer: Int = config.getBytes("blogOnSubmitMaxMemoryBuffer").getOrElse(512 * 1024L).asInstanceOf[Int]

  def showAdminPage(url: String) = silhouette.SecuredAction(Admin).async { implicit request =>
    pagesDAO.getPage(url, implicitly[Lang].code).map {
      case Some(page) =>
        Ok(views.html.pages.adminPage(request.identity, FormsData.pageForm.fill(PageFormData(page, None))))
      case _ =>
        Redirect(controllers.pages.routes.ApplicationController.index())
          .flashing("error" -> Messages("pages.not-found", url))
    }
  }

  def onSubmit(url: String) = silhouette.SecuredAction(Admin).async(parse.urlFormEncoded(onSubmitMaxMemoryBuffer)) { implicit request =>
    FormsData.pageForm.bindFromRequest().fold(
      errorForm => {
        Future(Ok(s"ERROR $errorForm"))
      },
      pageFormData => {
        //        Logger.info(s"Going to ${action.head} $article ...")
        pageFormData.action match {
          case Some("new") =>
            pagesDAO.upsertPage(pageFormData.page).map { _ =>
              Redirect(controllers.pages.routes.AdminPage.showAdminPage(pageFormData.page.url))
                .flashing("success" -> Messages("pages.page-upsert"))
            }
          case Some("save") =>
            val errorMsg = Messages("page.unknown-command", "")
            Logger.error(errorMsg)
            Future(Redirect(controllers.pages.routes.AdminPage.showAdminPage("")).flashing("error" -> errorMsg))
          case Some("delete") =>
            val errorMsg = Messages("page.unknown-command")
            Logger.error(errorMsg)
            Future(Redirect(controllers.pages.routes.AdminPage.showAdminPage("")).flashing("error" -> errorMsg))
          case unknown =>
            val errorMsg = Messages("page.unknown-command", unknown.toString())
            Logger.error(errorMsg)
            Future(Redirect(controllers.pages.routes.AdminPage.showAdminPage("")).flashing("error" -> errorMsg))
        }
      }
    )
  }
}

