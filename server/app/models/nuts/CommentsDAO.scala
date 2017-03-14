package models.nuts

import javax.inject.Inject

import models.nuts.Data.{ Article, Comment }
import models.nuts.Tables.{ comments, insertArticle }
import play.api.db.slick.DatabaseConfigProvider
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend

import scala.concurrent.Future

/**
 * Created by snc on 2/25/17.
 */
class CommentsDAO @Inject() (dbConfigProvider: DatabaseConfigProvider) {

  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db
  import dbConfig.driver.api._

  def getComments(articleID: Long): Future[Seq[Comment]] = db.run(comments.filter(_.id === articleID).result)

  //  def addNewArticle(article: Article): Future[Article] = db.run(insertArticle += article)
  //
  //  def updateArticle(article: Article) = db.run(articles.filter(_.id === article.id).update(article))
  //
  //  def deleteArticle(id: Long): Future[Int] = db.run(articles.filter(_.id === id).delete)

}
