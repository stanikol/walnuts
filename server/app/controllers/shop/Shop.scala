///**
// * Created by snc on 2/28/17.
// */
//package controllers.shop
//
//import java.util.UUID
//
//import akka.actor.ActorSystem
//import akka.stream.Materializer
//import com.mohiva.play.silhouette.api.actions.{ UserAwareAction, UserAwareRequest }
//import com.mohiva.play.silhouette.api.{ HandlerResult, Silhouette }
//import controllers.BaseController
//import models.auth.AuthEnv
//import models.shop.{ GoodsItem, Order, Size, DAO => ShopDAO }
//import models.user.{ DAO => UsrDAO }
//import models.{ RequestMessage, ResponseMessage }
//import org.joda.time.DateTime
//import org.joda.time.format.DateTimeFormat
//import play.api.i18n.{ I18nSupport, Messages, MessagesApi }
//import play.api.libs.concurrent.Execution.Implicits.defaultContext
//import play.api.libs.streams.ActorFlow
//import play.api.mvc._
//import services.socket.SocketService
//import utils.{ Application, Logging }
//import utils.metrics.Instrumented
//import utils.web.MessageFrameFormatter
//import models.shop.Const._
//import play.api.Logger
//import play.api.data.FormError
//import play.api.i18n.Messages.Message
//import play.twirl.api.HtmlFormat
//import views.shop.FormsData
//
//import scala.concurrent.Future
//
//@javax.inject.Singleton
//class Shop @javax.inject.Inject() (
//    val shopDAO: ShopDAO,
//    val usrDAO: UsrDAO,
//    //                                    val app: Application,
//    val silhouette: Silhouette[AuthEnv],
//    val messagesApi: MessagesApi
////                                    implicit val system: ActorSystem,
////                                    implicit val materializer: Materializer
//) extends Controller with Instrumented with Logging with I18nSupport {
//  import views.shop.FormsData._
//  //  import formsData._
//  def index = silhouette.UserAwareAction.async { implicit request =>
//    displayShop
//  }
//
//  def buy = silhouette.UserAwareAction.async { implicit request =>
//    addToShopCartForm.bindFromRequest().fold(
//      { withErrors =>
//        val errorMsg = withErrors.errors.map {
//          case FormError("id", m, a) => Messages("Please select an item to buy!")
//          case FormError("size", m, a) => Messages("Size is not specified")
//          case FormError("qnt", m, a) => Messages("Quantity is unspecified")
//        }
//        Future(Redirect(routes.Shop.index()).flashing("error" -> errorMsg.mkString("<br>")))
//      },
//      ok => shopDAO.addToShoppingCart(getShopCartID(), ok.goodsItemID, ok.qnt, ok.size).map { _ => Redirect(routes.Shop.index()) }
//    )
//  }
//
//  def showShopCart = silhouette.UserAwareAction.async { implicit request =>
//    shopDAO.getShopCartItems(getShopCartID()).map { itemsOrdered =>
//      OkWithUsrCookie(views.html.shop.shopCart(request.identity, itemsOrdered))
//    }
//  }
//
//  def changeQnt = silhouette.UserAwareAction.async { implicit request =>
//    changeQntForm.bindFromRequest().fold(
//      error => Future(BadRequest(error.toString)),
//      { ok =>
//        shopDAO.changeQnt(getShopCartID(), ok.orderedItemID, ok.newQnt).map { updatedOrder =>
//          Logger.info(s"changeQnt -> $ok")
//          OkWithUsrCookie(views.html.shop.shopCart(request.identity, updatedOrder))
//        }
//      }
//    )
//  }
//
//  def checkout = silhouette.UserAwareAction.async { implicit request =>
//    checkoutForm.bindFromRequest().fold(
//      { errors =>
//        val errorMsg = errors.errors.map { case FormError(key, error, args) => s"$key -> $error" }.mkString("; ")
//        Future(Redirect(routes.Shop.showShopCart).flashing("error" -> errorMsg))
//      },
//      { ok =>
//        val emailInCookie = getShopCartID()
//        usrDAO.hasUser(ok.email).flatMap { hasUser =>
//          //          Future(Ok(s"$ok $hasUser $emailInCookie"))
//          if (emailInCookie != ok.email && request.identity.isEmpty)
//            Future(Redirect(controllers.auth.routes.AuthenticationController.signInForm())
//              .withSession("returnUrl" -> routes.Shop.showShopCart().absoluteURL()))
//          else
//            Future(Ok(s"$ok $hasUser $emailInCookie"))
//        }
//      }
//    )
//  }
//
//  private def displayShop(implicit request: UserAwareRequest[AuthEnv, AnyContent]) = {
//    val shopCartID: UUID = getShopCartID()
//    shopDAO.getAllSizes.flatMap { sizes: Seq[Size] =>
//      shopDAO.getShopCartItems(shopCartID).flatMap { itemsOrdered =>
//        shopDAO.gelAllGoodsItems.map { goods: Seq[GoodsItem] =>
//          OkWithUsrCookie(views.html.shop.index(request.identity, goods, sizes, itemsOrdered), shopCartID.toString)
//        }
//      }
//    }
//  }
//
//  private val dateTimeFormat = DateTimeFormat.forPattern("yyyy-MM-dd_HH:mm:ss_S")
//
//  private def getShopCartID(cookie: String = SHOP_CART_ID_COOKIE)(implicit request: UserAwareRequest[AuthEnv, AnyContent]): UUID = {
//    request.cookies.get(cookie) match {
//      case None =>
//        java.util.UUID.randomUUID()
//      case Some(cookie) => UUID.fromString(cookie.value)
//    }
//  }
//
//  //  private def userCookie = Cookie(SHOP_CART_ID_COOKIE, getUserOrTmpID())
//
//  private def OkWithUsrCookie(result: HtmlFormat.Appendable, userCookie: String = "")(implicit request: UserAwareRequest[AuthEnv, AnyContent]) = Ok(result)
//    .withCookies(Cookie(SHOP_CART_ID_COOKIE, if (userCookie.isEmpty) getShopCartID().toString else userCookie))
//
//}
