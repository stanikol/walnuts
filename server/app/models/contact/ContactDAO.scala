package models.contact

import javax.inject.Inject

import play.api.Logger
import play.api.db.slick.DatabaseConfigProvider
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend

import scala.concurrent.Future

/**
 * Created by snc on 2/25/17.
 */
class ContactDAO @Inject() (dbConfigProvider: DatabaseConfigProvider) {

  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db
  import ContactTableDef._
  import dbConfig.driver.api._

  def getContact: Future[Option[Contact]] = db.run(contactTQ.result.headOption).recoverWith {
    case error =>
      Logger.error(s"Ошибка чтения контактов из БД ! ${error.getMessage}")
      Future.successful(None)
  }

  def getRichContact: Future[Option[RichContact]] = db.run(richContactTQ.result.headOption).recoverWith {
    case error =>
      Logger.error(s"Ошибка чтения изящьных контактов из БД ! ${error.getMessage}")
      Future.successful(None)
  }

}
