package controllers.sitemap

import javax.inject.Inject

import akka.stream.Materializer
import com.mohiva.play.silhouette.api.Silhouette
import controllers.WebJarAssets
import models.blog.BlogDAO
import models.goods.{ GoodsCategoriesDAO, GoodsDAO }
import play.api.Configuration
import play.api.i18n.{ I18nSupport, MessagesApi }
import play.api.mvc.{ Action, Controller }
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import utils.auth.DefaultEnv

import scala.concurrent.Future

/**
 * Created by snc on 5/10/17.
 */
class Sitemap @Inject() (
    val goodsDAO: GoodsDAO,
    val blogDAO: BlogDAO,
    val silhouette: Silhouette[DefaultEnv],
    val config: Configuration,
    val messagesApi: MessagesApi,
    implicit val webJarAssets: WebJarAssets,
    implicit val mat: Materializer
) extends Controller with I18nSupport {

  val domainName: String = config.getString("domain-name").getOrElse("")

  def sitemap = Action.async { implicit request =>
    goodsDAO.listAllGoods.flatMap { goods =>
      blogDAO.getAllArticles.map { articles =>
        Ok(views.xml.sitemap(goods, articles))
      }
    }
  }

  def robots() = Action.async { implicit request =>
    val sitemapURL = controllers.sitemap.routes.Sitemap.sitemap().absoluteURL()
    Future.successful(Ok(
      s"""User-agent: *
       |Disallow: /admin
       |
       |Sitemap: $sitemapURL""".stripMargin
    ))
  }

}
