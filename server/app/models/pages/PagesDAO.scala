package models.pages

import javax.inject.Inject

import com.google.inject.Singleton
import play.api.db.slick.DatabaseConfigProvider
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend
import PagesTableDef._

import scala.concurrent.Future

/**
 * Created by snc on 2/25/17.
 */
@Singleton
class PagesDAO @Inject() (dbConfigProvider: DatabaseConfigProvider) {

  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db
  import dbConfig.driver.api._

  def getPage(fileName: String, langCode: String): Future[Option[Page]] = db.run(
    pages.filter(p => p.url === fileName && p.lang === langCode).result.headOption
  )

  def upsertPage(page: Page) = db.run(
    pages.insertOrUpdate(page)
  )

  def deletePage(pageUrl: String, langCode: String) = db.run(
    pages.filter(p => p.url === pageUrl && p.lang === langCode).delete
  )

}
