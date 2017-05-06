package controllers.goods

/**
 * Created by stanikol on 1/29/17.
 */

import javax.inject._

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.goods._
import FormsData._
//import models.blog._
import play.api.Configuration
import play.api.i18n.{ I18nSupport, Messages, MessagesApi }
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc._
import utils.auth.{ DefaultEnv, Roles }

import scala.concurrent.Future

class Goods @Inject() (
    val goodsDAO: GoodsDAO,
    val goodsCategoriesDAO: GoodsCategoriesDAO,
    val silhouette: Silhouette[DefaultEnv],
    val config: Configuration,
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets,
    implicit val mat: Materializer
) extends Controller with I18nSupport {

  val onSubmitMaxMemoryBuffer: Int = config.getBytes("blogOnSubmitMaxMemoryBuffer").getOrElse(512 * 1024L).asInstanceOf[Int]

  def listAllGoods = silhouette.UserAwareAction.async { implicit request =>
    goodsDAO.listAllGoods.map { goods: Seq[GoodsItemView] =>
      Ok(views.html.goods.listAll(request.identity, goods))
    }
  }

  def getGoodsItem(id: Long) = silhouette.UserAwareAction.async { implicit request =>
    goodsDAO.getGoodsItem(id).map { goodsItemOpt =>
      goodsItemOpt match {
        case None => BadRequest(Messages("No item #{0} was found !", id))
        case Some(goodsItem) => Ok(views.html.goods.showItem(request.identity, goodsItem))

      }
    }
  }

  def showItemEditForm(itemID: Option[Long]) = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    val goodsItem: Future[GoodsItem] = itemID match {
      case None => Future(GoodsItem.empty)
      case Some(id) => goodsDAO.getGoodsItem(id).map { goodsItemView => GoodsItem.fromGoodsItemView(goodsItemView.get) }
    }
    val goodsCategories: Future[Seq[Category]] = goodsCategoriesDAO.listCategories
    goodsItem.flatMap { item =>
      goodsCategories.map { cats =>
        Ok(views.html.goods.itemEditForm(request.identity, goodsItemForm.fill(item), cats))
      }

    }
  }

  def itemEditFormHandle = silhouette.SecuredAction(Roles.Admin).async(parse.urlFormEncoded(onSubmitMaxMemoryBuffer)) { implicit request =>
    actionForm.bindFromRequest().fold(
      { error => Future(BadRequest(Messages("Error: No command was given !"))) },
      { action =>
        goodsItemForm.bindFromRequest().fold(
          { errors =>
            goodsCategoriesDAO.listCategories.map { cats =>
              BadRequest(views.html.goods.itemEditForm(request.identity, errors, cats))
            }
          },
          { ok =>
            action match {
              case Some("new") =>
                goodsDAO.createNewGoodsItem(ok).map(newItem =>
                  Redirect(controllers.goods.routes.Goods.showItemEditForm(newItem.id))
                    .flashing("success" -> s"Item #${newItem.id.get} is created."))
              case Some("save") if ok.id.isDefined =>
                goodsDAO.updateGoodsItem(ok).map(updatedItem =>
                  Redirect(controllers.goods.routes.Goods.showItemEditForm(updatedItem.id))
                    .flashing("success" -> s"Item #${updatedItem.id.get} is updated."))
              case Some("delete") if ok.id.isDefined =>
                goodsDAO.deleteGoodsItem(ok.id.get).map(rowsAffected =>
                  Redirect(controllers.goods.routes.Goods.showItemEditForm(None))
                    .flashing("success" -> s"$rowsAffected item #${ok.id.get} is deleted."))

            }
          }
        )
      }
    )

  }
}

