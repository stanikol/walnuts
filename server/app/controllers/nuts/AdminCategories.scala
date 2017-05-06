package controllers.nuts

import javax.inject.Inject

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.goods.{ GoodsCategoriesDAO, GoodsDAO }
import models.blog.FormsData._
import models.goods.GoodsDAO
import models.images.ImageCategoriesDAO
import play.api.Configuration
import play.api.i18n.{ I18nSupport, MessagesApi }
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc.Controller
import play.api.mvc.Results._
import utils.auth.{ DefaultEnv, Roles }

import scala.concurrent.Future
///**
// * Created by snc on 5/5/17.
// */
//trait AdminCategories extends I18nSupport {
//  val goodsCategoriesDAO: GoodsCategoriesDAO
//  val imageCategoriesDAO: ImageCategoriesDAO
//  val silhouette: Silhouette[DefaultEnv]
//  val config: Configuration
//  val messagesApi: MessagesApi
//  implicit val webJarAssets: WebJarAssets
//  implicit val mat: Materializer

class AdminCategories @Inject() (
    //    blogDAO: BlogDAO,
    //    commentsDAO: CommentsDAO,
    val goodsDAO: GoodsDAO,
    val goodsCategoriesDAO: GoodsCategoriesDAO,
    val imageCategoriesDAO: ImageCategoriesDAO,
    val silhouette: Silhouette[DefaultEnv],
    val config: Configuration,
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets,
    implicit val mat: Materializer
) extends Controller with I18nSupport {

  // GOODS CATEGORIES

  def adminGoodsCategories = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    goodsCategoriesDAO.listCategories.map { categories =>
      val submitTo = controllers.nuts.routes.AdminCategories.adminGoodsCategoriesHandle
      Ok(views.html.adminCategories(request.identity, categories, submitTo))
    }
  }

  def adminGoodsCategoriesHandle = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    categoryForm.bindFromRequest().fold(
      error => Future(Redirect(controllers.nuts.routes.AdminCategories.adminGoodsCategoriesHandle)
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
            Redirect(controllers.nuts.routes.AdminCategories.adminGoodsCategories).flashing(status -> msg)
        }
      }
    )
  }

  // PHOTO ALBUMS CATEGORIES

  def adminAlbumsCategories = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    imageCategoriesDAO.listCategories.map { categories =>
      val submitTo = controllers.nuts.routes.AdminCategories.adminAlbumsCategoriesHandle
      Ok(views.html.adminCategories(request.identity, categories, submitTo))
    }
  }

  def adminAlbumsCategoriesHandle = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
    categoryForm.bindFromRequest().fold(
      error => Future(Redirect(controllers.nuts.routes.AdminCategories.adminAlbumsCategories)
        .flashing("error" -> ("Инвалидные данные: " + error.errors.mkString("\n")))),
      categoryEdit => {
        val category = categoryEdit.category
        (categoryEdit.action match {
          case "save" =>
            category.id match {
              case Some(id) =>
                imageCategoriesDAO.upsertCategory(category).map(_ => "ok" -> s"Внесены изменения в БД, категория: $category")
              case None =>
                imageCategoriesDAO.addCategory(category).map(_ => "ok" -> s"Новая категория добавлена в БД: $category")
            }
          case "del" =>
            if (category.id.isDefined)
              imageCategoriesDAO.deleteCategory(category.id.get).map(_ => "ok" -> s"Из БД удалена категория: $category")
            else
              Future("error" -> s"ID катерогии не указан, удаление не возможно !")
        }).map {
          case (status, msg) =>
            Redirect(controllers.nuts.routes.AdminCategories.adminAlbumsCategories).flashing(status -> msg)
        }
      }
    )
  }

}
