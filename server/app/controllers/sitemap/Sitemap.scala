package controllers.sitemap

import javax.inject.Inject

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.blog.BlogDAO
import models.goods.{ GoodsCategoriesDAO, GoodsDAO }
import models.images.{ ImageInfo, ImagesDAO }
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import play.api.Configuration
import play.api.i18n.{ I18nSupport, MessagesApi }
import play.api.mvc.{ Action, Controller }
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import utils.auth.DefaultEnv

import scala.collection.JavaConversions._
import scala.concurrent.Future

/**
 * Created by snc on 5/10/17.
 */
class Sitemap @Inject() (
    val goodsDAO: GoodsDAO,
    val blogDAO: BlogDAO,
    val imagesDAO: ImagesDAO,
    val silhouette: Silhouette[DefaultEnv],
    val config: Configuration,
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets,
    implicit val mat: Materializer
) extends Controller with I18nSupport {

  val domainName: String = config.getString("domain-name").getOrElse("")

  def sitemap = Action.async { implicit request =>
    imagesDAO.listAllImageInfo.flatMap { images: Seq[ImageInfo] =>
      val imagesMap = images.foldLeft(Map.empty[String, ImageInfo]) { case (m, ii) => m.updated(ii.name, ii) }
      goodsDAO.listAllGoods.flatMap { goods =>
        blogDAO.getAllArticles.map { articles =>
          val articlesNameAndTitle: Map[Long, Seq[(String, String)]] =
            articles.filter(_.id.isDefined).map { article =>
              val soup = Jsoup.parse(article.text)
              soup.select("img").map { i: Element =>
                val src = i.attr("src")
                if (!src.startsWith("data")) {
                  src.split("/").last
                } else {
                  ""
                }
              }.filter { imageName: String =>
                imageName.nonEmpty && imagesMap.keys.contains(imageName)
              }.map { imageName =>
                val imageTitle = imagesMap(imageName).content
                (article.id.get, imageName, imageTitle)
              }
            }.flatten.groupBy(_._1).mapValues(_.map(i => i._2 -> i._3))
          Ok(views.xml.sitemap(goods, articlesNameAndTitle))
        }
      }
    }
  }

  def robots() = Action.async { implicit request =>
    val sitemapURL = controllers.sitemap.routes.Sitemap.sitemap().absoluteURL()
    Future.successful(Ok(
      s"""User-agent: *
       |
       |Sitemap: $sitemapURL""".stripMargin
    ))
  }

}
