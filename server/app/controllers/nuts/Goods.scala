package controllers.nuts

/**
 * Created by stanikol on 1/29/17.
 */

import javax.inject._

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.nuts.{ BlogDAO, CommentsDAO, GoodsDAO }
import models.nuts.Data.{ Article, Comment, CommentInfo, GoodsItem }
import models.nuts.FormsData._
import play.api.i18n.{ I18nSupport, Messages }
import utils.auth.Roles.Admin
import play.api.{ Configuration, Logger }
import play.api.i18n.MessagesApi
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc._
import utils.auth.{ DefaultEnv, Roles }

import scala.concurrent.Future

class Goods @Inject() (
    //    blogDAO: BlogDAO,
    //    commentsDAO: CommentsDAO,
    goodsDAO: GoodsDAO,
    silhouette: Silhouette[DefaultEnv],
    config: Configuration,
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets,
    implicit val mat: Materializer
) extends Controller with I18nSupport {

  val onSubmitMaxMemoryBuffer: Int = config.getBytes("blogOnSubmitMaxMemoryBuffer").getOrElse(512 * 1024L).asInstanceOf[Int]

  def listAllGoods = silhouette.UserAwareAction.async { implicit request =>
    goodsDAO.listAllGoods.map { goods: Seq[GoodsItem] =>
      Ok(views.html.goods.listAll(request.identity, goods))
    }
  }

  def get(id: Long) = silhouette.UserAwareAction.async { implicit request =>
    goodsDAO.get(id).map { goodsItemOpt =>
      goodsItemOpt match {
        case None => BadRequest(Messages("No item #{0} was found !", id))
        case Some(goodsItem) => Ok(views.html.goods.showItem(request.identity, goodsItem))

      }
    }
  }

  def viewEditForm(itemID: Option[Long]) = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    itemID match {
      case None =>
        Future(Ok(views.html.goods.itemEditForm(request.identity, goodsItemForm.fill(GoodsItem.empty))))
      case Some(id) =>
        goodsDAO.get(id).map(goodsItem =>
          Ok(views.html.goods.itemEditForm(request.identity, goodsItemForm.fill(goodsItem.get))))
    }

  }

  def updateOrCreateOrDelete = silhouette.SecuredAction(Roles.Admin).async(parse.urlFormEncoded(onSubmitMaxMemoryBuffer)) { implicit request =>
    actionForm.bindFromRequest().fold(
      { error => Future(BadRequest(Messages("Error: No command was given !"))) },
      { action =>
        goodsItemForm.bindFromRequest().fold(
          { errors => Future(BadRequest(views.html.goods.itemEditForm(request.identity, errors))) },
          { ok =>
            action match {
              case Some("new") =>
                goodsDAO.createNew(ok).map(newItem =>
                  Redirect(controllers.nuts.routes.Goods.viewEditForm(newItem.id))
                    .flashing("success" -> s"Item #${newItem.id.get} is created."))
              case Some("save") if ok.id.isDefined =>
                goodsDAO.update(ok).map(updatedItem =>
                  Redirect(controllers.nuts.routes.Goods.viewEditForm(updatedItem.id))
                    .flashing("success" -> s"Item #${updatedItem.id.get} is updated."))
              case Some("delete") if ok.id.isDefined =>
                goodsDAO.delete(ok.id.get).map(rowsAffected =>
                  Redirect(controllers.nuts.routes.Goods.viewEditForm(None))
                    .flashing("success" -> s"$rowsAffected item #${ok.id.get} is deleted."))

            }
          }
        )
      }
    )

  }

}

