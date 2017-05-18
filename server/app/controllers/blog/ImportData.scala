package controllers.blog

/**
 * Created by snc on 4/27/17.
 */
import java.io.File
import javax.inject._

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.blog.{ Article, _ }
import models.goods.GoodsTableDef._
import models.goods.{ Category, GoodsCategoriesDAO, GoodsDAO, GoodsItem }
import models.images.{ Image, ImagesDAO }
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import play.api.db.slick.DatabaseConfigProvider
import play.api.i18n.{ I18nSupport, MessagesApi }
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc._
import play.api.{ Configuration, Logger }
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend
import utils.auth.{ DefaultEnv, Roles }

import scala.collection.JavaConversions._
import scala.concurrent.duration.Duration
import scala.concurrent.{ Await, Future }

class ImportData @Inject() (
    blogDAO: BlogDAO,
    val goodsDAO: GoodsDAO,
    val imagesDAO: ImagesDAO,
    val goodsCategoriesDAO: GoodsCategoriesDAO,
    silhouette: Silhouette[DefaultEnv],
    config: Configuration,
    dbConfigProvider: DatabaseConfigProvider,
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets,
    implicit val mat: Materializer
) extends Controller with I18nSupport {

  private val dbConfig2: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  import dbConfig2.driver.api._
  private val db2: JdbcBackend#DatabaseDef = dbConfig2.db

  def images = {
    val imagesNuts = grab.GrabRead.readImagesFromDir(new File("grab/nuts")).toList
    imagesNuts.map {
      case (image: Image, bytes: Array[Byte]) =>
        Logger.info(s"ImportData => Upserting ${bytes.length} bytes in ${image.name} ...")
        imagesDAO.insertOrUpdateImage(image, Some(Seq(1)), Some(bytes))
        image
    }
    val imagesArticles = grab.GrabRead.readImagesFromDir(new File("grab/articles")).toList
    imagesArticles.map {
      case (image: Image, bytes: Array[Byte]) =>
        Logger.info(s"ImportData => Upserting ${bytes.length} bytes in ${image.name} ...")
        imagesDAO.insertOrUpdateImage(image, Some(Seq(2)), Some(bytes))
        image
    }
    val (g, a) = assignContentToImages()
    imagesArticles ++ imagesNuts ++ g ++ a
  }

  private def assignContentToImages() = {
    val articlesImagesF: Future[Map[String, Seq[String]]] = blogDAO.getAllArticles.map {
      _.map { article: Article =>
        val soup = Jsoup.parse(article.text)
        val imagesNames = soup.select("img").map { case e: Element => e.attr("src").split("/").last }.filter(!_.startsWith("data"))
        Logger.info(s"В статье ${article.title} \n\tнайдено ${imagesNames.mkString(", ")}")
        imagesNames.map { imageName =>
          imagesDAO.updateImageContent(imageName, article.title)
        }
        article.title -> imagesNames
      }.filter(_._2.nonEmpty).toMap
    }
    val goodsImagesTitlesF: Future[Map[String, String]] =
      db2.run(models.goods.GoodsTableDef.goods.filter(_.image.nonEmpty).map(g => g.image.get -> g.title).result).map {
        _.map {
          case x @ (imageName, imageTitle) =>
            imagesDAO.updateImageContent(imageName, s"Сорт $imageTitle")
            Logger.info(s"$imageName $imageTitle")
            x
        }.toMap
      }

    Await.result(articlesImagesF flatMap (a => goodsImagesTitlesF.map(_ -> a)), Duration.Inf)
  }

  def importImages = silhouette.SecuredAction(Roles.Admin) { implicit request =>
    Ok(s"$images ")
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
          blogDAO.upsertArticle(newArticle)
          newArticle.title
      }
    }
  }
  def importArticles = silhouette.SecuredAction(Roles.Admin) { implicit request =>
    Ok(s"$articles")
  }

  def nuts = {
    case class TSV(id: Int, name: String, category: String, imageName: String)
    val index = scala.io.Source.fromFile("grab/nuts/nuts-index.tsv").getLines().map { line =>
      val splitted = line.split("\t")
      val (id: String, name: String, category: String, image: String) = (splitted(0), splitted(1), splitted(2), splitted(3))
      TSV(id.toInt, name, category, image)
    }.toList
    //
    index.groupBy(_.category).keys.map { category =>
      val q = categories += Category(None, category, "")
      db2.run(q)
    }
    //
    val files = grab.GrabRead.getFileTree(new File("grab/nuts")).filter(_.getName.endsWith(".html")).toList
    val Reg = """grab/nuts/\d+/(\d+)\.html""".r
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
