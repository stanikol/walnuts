package controllers.goods

/**
 * Created by stanikol on 1/29/17.
 */

import javax.inject._

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.goods._
import play.api.Configuration
import play.api.i18n.{ I18nSupport, Messages, MessagesApi }
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc._
import utils.auth.DefaultEnv

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

  def showAllGoodsItems = silhouette.UserAwareAction.async { implicit request =>
    goodsDAO.listAllGoods.map { goods: Seq[GoodsItemView] =>
      Ok(views.html.goods.showAllGoodsItems(request.identity, goods))
    }
  }

  def getGoodsItem(id: Long) = silhouette.UserAwareAction.async { implicit request =>
    goodsDAO.getGoodsItem(id).map { goodsItemOpt =>
      goodsItemOpt match {
        case None => Redirect(controllers.goods.routes.Goods.showAllGoodsItems()).flashing(
          "error" -> Messages("goods.item-not-found", id)
        )
        case Some(goodsItem) => Ok(views.html.goods.showItem(request.identity, goodsItem))

      }
    }
  }

}

