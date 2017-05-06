package controllers.nuts

/**
 * Created by snc on 4/27/17.
 */
import java.io.File
import javax.inject._

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.goods.{ Category, GoodsCategoriesDAO, GoodsDAO, GoodsItem }
import models.goods.GoodsTableDef._
import models.blog._
import models.blog.Data.{ Article, Comment, CommentInfo }
import models.blog.FormsData._
import models.images.ImagesDAO
import play.api.db.slick.DatabaseConfigProvider
import play.api.i18n.{ I18nSupport, Messages }
import utils.auth.Roles.Admin
import play.api.{ Configuration, Logger }
import play.api.i18n.MessagesApi
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc._
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend
import slick.model.Table
import utils.auth.{ DefaultEnv, Roles }

import scala.concurrent.duration.Duration
import scala.concurrent.{ Await, Future }

class ImportData @Inject() (
    blogDAO: BlogDAO,
    //    commentsDAO: CommentsDAO,
    val goodsDAO: GoodsDAO,
    val imagesDAO: ImagesDAO,
    val goodsCategoriesDAO: GoodsCategoriesDAO,
    //    val imageCategoriesDAO: ImageCategoriesDAO,
    silhouette: Silhouette[DefaultEnv],
    config: Configuration,
    dbConfigProvider: DatabaseConfigProvider,
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets,
    implicit val mat: Materializer
) extends Controller with I18nSupport {

  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db

  def images = {
    val images = grab.GrabRead.readImagesFromDir(new File("grab")).toList
    images.map { image =>
      Logger.info(s"Upserting ${image.name}")
      imagesDAO.upsertImage(image, Some(Seq(1)))
      image
    }
  }

  def importImages = silhouette.SecuredAction(Roles.Admin) { implicit request =>
    Ok(s"$images")
  }

  def articles = {
    case class TSV(id: Int, filename: String, title: String)
    val index = scala.io.Source.fromFile("grab/articles/article-index.tsv").getLines().map { line =>
      val splitted = line.split("\t")
      val (id: String, filename: String, title: String) = (splitted(0), splitted(1), splitted(2))
      TSV(id.toInt, filename, title)
    }.toList
    //
    val files = grab.GrabRead.getFileTree(new File("grab/articles")).filter(_.getName.endsWith(".html")).toList
    val Reg = """grab/articles/\d+/(\d+)\.html""".r
    files.map { filename =>
      filename.getPath match {
        case Reg(id) =>
          val _id = id.toLong
          val text = scala.io.Source.fromFile(filename).mkString.replace("/assets/images/", "/img/")
          val title = index.filter(_.id == _id).map(_.title).head
          val shortText = org.jsoup.Jsoup.parse(text).text().replaceAll("[\\s\\t\\n]+", " ").split("\\s").take(60).mkString(" ") + " ..."
          val newArticle = Article(Some(_id), "sort", "kw", title, text, "descr", shortText)
          blogDAO.addNewArticle(newArticle)
          newArticle.title
      }
    }
  }
  def importArticles = silhouette.SecuredAction(Roles.Admin) { implicit request =>
    Ok(s"$articles")
  }

  def nuts = {
    case class TSV(id: Int, name: String, category: String, imageName: String)
    val index = scala.io.Source.fromFile("grab/blog/blog-index.tsv").getLines().map { line =>
      val splitted = line.split("\t")
      val (id: String, name: String, category: String, image: String) = (splitted(0), splitted(1), splitted(2), splitted(3))
      TSV(id.toInt, name, category, image)
    }.toList
    //
    import dbConfig.driver.api._
    index.groupBy(_.category).keys.map { category =>
      val q = categories += Category(None, category, "")
      db.run(q)
    }
    //
    val files = grab.GrabRead.getFileTree(new File("grab/blog")).filter(_.getName.endsWith(".html")).toList
    val Reg = """grab/blog/\d+/(\d+)\.html""".r
    files.map { filename =>
      filename.getPath match {
        case Reg(id) =>
          val _id = id.toLong
          val tsv = index.filter(_.id == _id).head
          val text = scala.io.Source.fromFile(filename).mkString.replace("/assets/images/", "/img/")
          val category: Future[Int] = goodsCategoriesDAO.listCategories.flatMap { categories =>
            categories.filter(_.name == tsv.category).headOption match {
              case Some(category) =>
                Future(category.id.getOrElse(0))
              case None =>
                goodsCategoriesDAO.addCategory(Category(None, tsv.category, "")).map(_.id.getOrElse(0))
            }
          }
          val newGoodsItem = GoodsItem(
            Some(_id),
            Await.result(category, Duration.Inf),
            tsv.name,
            text, 100, 1, "", Some(tsv.imageName)
          )
          goodsDAO.createNewGoodsItem(newGoodsItem)
          newGoodsItem.title
      }
    }
  }

  def importNuts = silhouette.SecuredAction(Roles.Admin) { implicit request =>
    Ok(s"$nuts")
  }

  def importAll = silhouette.SecuredAction(Roles.Admin) { implicit request =>
    Ok(s"""Images:
         |$images
         |Nuts:
         |$nuts
         |Articles:
         |${articles}""".stripMargin)
  }

}
