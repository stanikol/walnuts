//package controllers.nuts
//
///**
// * Created by snc on 4/28/17.
// */
//
//import java.io.File
//import javax.inject._
//
//import akka.stream.Materializer
//import com.mohiva.play.silhouette.api.Silhouette
//import controllers.WebJarAssets
//import models.blog._
//import models.blog.Data.{ Article, Category, Comment, CommentInfo, GoodsItem }
//import models.blog.FormsData._
//import models.images.ImagesDAO
//import play.api.data.Form
//import play.api.db.slick.DatabaseConfigProvider
//import play.api.http.ContentTypes
//import play.api.i18n.{ I18nSupport, Messages }
//import play.api.libs.json._
//import utils.auth.Roles.Admin
//import play.api.{ Configuration, Logger }
//import play.api.i18n.MessagesApi
//import play.api.libs.concurrent.Execution.Implicits._
//import play.api.mvc._
//import slick.backend.DatabaseConfig
//import slick.driver.JdbcProfile
//import slick.jdbc.JdbcBackend
//import slick.model.Table
//import utils.auth.{ DefaultEnv, Roles }
//
//import scala.concurrent.Future
//
//class Admin @Inject() (
//    blogDAO: BlogDAO,
//    //    commentsDAO: CommentsDAO,
//    goodsDAO: GoodsDAO,
//    imagesDAO: ImagesDAO,
//    silhouette: Silhouette[DefaultEnv],
//    config: Configuration,
//    dbConfigProvider: DatabaseConfigProvider,
//    val messagesApi: MessagesApi,
//    implicit val webJarAssets: WebJarAssets,
//    implicit val mat: Materializer
//) extends Controller with I18nSupport {
//
//  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
//  private val db: JdbcBackend#DatabaseDef = dbConfig.db
//
//  //  def adminCategories = silhouette.SecuredAction(Roles.Admin).async { implicit request =>
//  //    goodsDAO.listCategories.map { categories =>
//  //      Ok(views.html.goods.adminCategories(request.identity, categories))
//  //    }
//  //  }
//
//  //  def adminCategoriesHandle = silhouette.SecuredAction(Roles.Admin) { implicit request =>
//  //
//  //    Logger.info(s"body => ${request.body.asFormUrlEncoded}")
//  //
//  //    val draw = dataTableForm.bindFromRequest().fold(
//  //      error => "ERROR dataTableForm >>>",
//  //      ok => ok
//  //    )
//  //    Logger.info(s"Draw == $draw")
//  //    Ok(s"""{"draw": $draw, "data":[["name", "pos"], ["name","pos"]], "recordsTotal":1, "recordsFiltered":1}""").as(ContentTypes.JSON)
//  //  }
//}
//
