package controllers.pages

import javax.inject.Inject

import com.mohiva.play.silhouette.api.{ LogoutEvent, Silhouette }
import com.mohiva.play.silhouette.impl.providers.SocialProviderRegistry
import controllers.{ WebJarAssets, pages }
import models.goods.{ GoodsDAO, GoodsItemView }
import models.pages.PagesDAO
import play.api.i18n.{ I18nSupport, Lang, MessagesApi }
import play.api.mvc.{ Action, AnyContent, Controller }
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import utils.auth.DefaultEnv

/**
 * The basic application controller.
 *
 * @param messagesApi The Play messages API.
 * @param silhouette The Silhouette stack.
 * @param socialProviderRegistry The social provider registry.
 * @param webJarAssets The webjar assets implementation.
 */
class ApplicationController @Inject() (
  blogDAO: models.blog.BlogDAO,
  goodsDAO: GoodsDAO,
  pagesDAO: PagesDAO,
  val messagesApi: MessagesApi,
  silhouette: Silhouette[DefaultEnv],
  socialProviderRegistry: SocialProviderRegistry,
  implicit val webJarAssets: WebJarAssets
)
    extends Controller with I18nSupport {

  /**
   * Handles the index action.
   *
   * @return The result to display.
   */
  def index: Action[AnyContent] = silhouette.UserAwareAction.async { implicit request =>
    import play.api.libs.concurrent.Execution.Implicits._
    goodsDAO.listAllGoods.flatMap { goods: Seq[GoodsItemView] =>
      blogDAO.getAllArticles.map { articles =>
        Ok(views.html.blog.showBlogAndGoods(request.identity, articles, goods))
      }
    }
  }

  /**
   * Handles the Sign Out action.
   *
   * @return The result to display.
   */
  def signOut: Action[AnyContent] = silhouette.SecuredAction.async { implicit request =>
    val result = Redirect(pages.routes.ApplicationController.index())
    silhouette.env.eventBus.publish(LogoutEvent(request.identity, request))
    silhouette.env.authenticatorService.discard(request.authenticator, result)
  }

  def showPage(url: String) = silhouette.UserAwareAction.async { implicit request =>
    val l = implicitly[Lang]
    l.code
    pagesDAO.getPage(url, "en").map {
      case Some(page) => Ok(views.html.pages.showPage(request.identity, page))
      case _ => Redirect(controllers.pages.routes.ApplicationController.index).flashing("error" -> s"Ресурс $url не найден!")
    }
  }
}
