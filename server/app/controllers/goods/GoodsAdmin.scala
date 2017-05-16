package controllers.goods

/**
 * Created by stanikol on 1/29/17.
 */

import javax.inject._

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import controllers.goods.FormsData._
import controllers.blog.FormsData.categoryForm
import models.goods._
import play.api.Configuration
import play.api.i18n.{ I18nSupport, Messages, MessagesApi }
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc._
import utils.auth.{ DefaultEnv, Roles }

import scala.concurrent.Future

class GoodsAdmin @Inject() (
    val goodsDAO: GoodsDAO,
    val goodsCategoriesDAO: GoodsCategoriesDAO,
    val silhouette: Silhouette[DefaultEnv],
    val config: Configuration,
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets,
    implicit val mat: Materializer
) extends Controller with I18nSupport {

  val onSubmitMaxMemoryBuffer: Int = config.getBytes("blogOnSubmitMaxMemoryBuffer").getOrElse(512 * 1024L).asInstanceOf[Int]

  def adminGoodsItem(itemID: Option[Long]) = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    val goodsItem: Future[GoodsItem] = itemID match {
      case None => Future(GoodsItem.empty)
      case Some(id) => goodsDAO.getGoodsItem(id).map { goodsItemView => GoodsItem.fromGoodsItemView(goodsItemView.get) }
    }
    val goodsCategories: Future[Seq[Category]] = goodsCategoriesDAO.listCategories
    goodsItem.flatMap { item =>
      goodsCategories.map { cats =>
        Ok(views.html.goods.adminGoodsItem(request.identity, goodsItemForm.fill(item), cats))
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
              BadRequest(views.html.goods.adminGoodsItem(request.identity, errors, cats)).flashing("error" -> "Инвалидные данные !!!")
            }
          },
          { ok =>
            action match {
              case Some("new") =>
                goodsDAO.createNewGoodsItem(ok).map(newItem =>
                  Redirect(controllers.goods.routes.GoodsAdmin.adminGoodsItem(newItem.id))
                    .flashing("success" -> s"Item #${newItem.id.get} is created."))
              case Some("save") if ok.id.isDefined =>
                goodsDAO.updateGoodsItem(ok).map(updatedItem =>
                  Redirect(controllers.goods.routes.GoodsAdmin.adminGoodsItem(updatedItem.id))
                    .flashing("success" -> s"Item #${updatedItem.id.get} is updated."))
              case Some("delete") if ok.id.isDefined =>
                goodsDAO.deleteGoodsItem(ok.id.get).map(rowsAffected =>
                  Redirect(controllers.goods.routes.GoodsAdmin.adminGoodsItem(None))
                    .flashing("success" -> s"$rowsAffected item #${ok.id.get} is deleted."))

            }
          }
        )
      }
    )

  }

  def adminGoodsCategories = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    goodsCategoriesDAO.listCategories.map { categories =>
      val submitTo = controllers.goods.routes.GoodsAdmin.adminGoodsCategoriesHandle
      Ok(views.html.adminCategories(request.identity, categories, submitTo))
    }
  }

  def adminGoodsCategoriesHandle = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    categoryForm.bindFromRequest().fold(
      error => Future(Redirect(controllers.goods.routes.GoodsAdmin.adminGoodsCategoriesHandle)
        .flashing("error" -> ("Инвалидные данные: " + error.errors.mkString("\n")))),
      categoryEdit => {
        val category = categoryEdit.category
        (categoryEdit.action match {
          case "save" =>
            category.id match {
              case Some(id) =>
                goodsCategoriesDAO.upsertCategory(category).map(_ => "ok" -> s"Внесены изменения в БД, категория: $category")
              case None =>
                goodsCategoriesDAO.addCategory(category).map(_ => "ok" -> s"Новая категория добавлена в БД: $category")
            }
          case "del" =>
            if (category.id.isDefined)
              goodsCategoriesDAO.deleteCategory(category.id.get).map(_ => "ok" -> s"Из БД удалена категория: $category")
            else
              Future("error" -> s"ID катерогии не указан, удаление не возможно !")
        }).map {
          case (status, msg) =>
            Redirect(controllers.goods.routes.GoodsAdmin.adminGoodsCategories).flashing(status -> msg)
        }
      }
    )
  }

}

