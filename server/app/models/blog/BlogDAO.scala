package models.blog

import javax.inject.Inject

//import models.blog.Article
import models.blog.BlogTablesDef.{ articles, insertArticle }
import play.api.db.slick.DatabaseConfigProvider
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend

import scala.concurrent.Future

/**
 * Created by snc on 2/25/17.
 */
class BlogDAO @Inject() (dbConfigProvider: DatabaseConfigProvider) {

  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db
  import dbConfig.driver.api._

  def getAllArticles: Future[Seq[Article]] = db.run(articles.sortBy(_.sort_order.desc).result)

  def getArticle(id: Long): Future[Option[Article]] = db.run(articles.filter(_.id === id).result.headOption)

  def addNewArticle(article: Article): Future[Article] = db.run(insertArticle += article)

  def upsertArticle(article: Article) = db.run(articles.insertOrUpdate(article))

  def updateArticle(article: Article) = db.run(articles.filter(_.id === article.id).update(article))

  def deleteArticle(id: Long): Future[Int] = db.run(articles.filter(_.id === id).delete)

}
