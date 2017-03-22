package models.nuts

/**
 * Created by stanikol on 1/27/17.
 */

import java.sql.{ Date, Time, Timestamp }
import java.time.LocalDateTime
import java.util.UUID

import models.tables.UserTable
import org.springframework.context.annotation.Description
import slick.lifted.TableQuery
//import play.api.http.ContentTypes
//import play.api.libs.json._
//import play.api.libs.functional.syntax._
import slick.driver.PostgresDriver.api._
//import MyPostgresDriver.api._
import models.nuts.Data._
/**
 * Created by stanikol on 10/21/16.
 */

object Tables {

  class Images(tag: Tag) extends Table[Image](tag, "images") {
    def name = column[String]("name", O.PrimaryKey)
    def content = column[String]("content")
    def bytes = column[Array[Byte]]("bytes")
    def * = (name, content, bytes) <> (Image.tupled, Image.unapply)
  }
  val images = TableQuery[Images]

  class Categories(tag: Tag) extends Table[Category](tag, "categories") {
    def name = column[String]("name", O.PrimaryKey)
    def * = (name) <> (Category.apply, Category.unapply)
  }
  val categories = TableQuery[Categories]

  class Articles(tag: Tag) extends Table[Article](tag, "articles") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def sort_order = column[String]("sort_order")
    def keywords = column[String]("keywords")
    def title = column[String]("title")
    def text = column[String]("article")
    def description = column[String]("description")
    def sort_text = column[String]("short_text")
    //    def * = (id.?, sort_order, keywords, title, text, description) <> (Article.tupled, Article.unapply)
    def * = (id.?, sort_order, keywords, title, text, description, sort_text) <> ((Article.apply _).tupled, Article.unapply)
  }
  val articles = TableQuery[Articles]
  val insertArticle = articles returning articles.map(_.id) into ((newArticle, id) => newArticle.copy(id = Some(id)))

  class Goods(tag: Tag) extends Table[GoodsItem](tag, "goods") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def category = column[String]("category")
    def title = column[String]("title")
    def description = column[String]("description")
    def qnt = column[Int]("qnt", O.Default(0))
    def price = column[BigDecimal]("price", O.Default(0))
    def showOrder = column[Int]("show_order", O.Default(0))
    def image = column[Option[String]]("image")
    def * = (id.?, category, title, description, qnt, price, showOrder, image) <> ((GoodsItem.apply _).tupled, GoodsItem.unapply)
    def categoryFK = foreignKey("CATEGORY_FK", category, categories)(_.name, onUpdate = ForeignKeyAction.Restrict, onDelete = ForeignKeyAction.Cascade)
  }
  val goods = TableQuery[Goods]
  val goodsReturning = goods returning (goods.map(_.id)) into ((goodsItem, newID) => goodsItem.copy(id = Some(newID)))

  class Comments(tag: Tag) extends Table[Comment](tag, "comments") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def userID = column[String]("user_id")
    def articleID = column[Long]("article_id")
    def text = column[String]("text")
    def added = column[Timestamp]("added")
    def * = (id.?, userID, articleID, text, added) <> (Comment.tupled, Comment.unapply)
    def userIDFK = foreignKey("USER_FK", userID, users)(_.fullName.getOrElse(""))
    def articleiDFK = foreignKey("ARTICLE_ID_FK", articleID, articles)(_.id)
  }

  val comments = TableQuery[Comments]

  class CommentsWithUsername(tag: Tag) extends Table[CommentInfo](tag, "comments_info") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def userID = column[String]("user_id")
    def userEmail = column[Option[String]]("email")
    def articleID = column[Long]("article_id")
    def articleTitle = column[String]("title")
    def text = column[String]("text")
    def added = column[Timestamp]("added")
    def username = column[String]("full_name")
    def * = (id.?, userID, userEmail, articleID, articleTitle, text, added, username) <> (CommentInfo.tupled, CommentInfo.unapply)
    //    def userIDFK = foreignKey("USER_FK", userID, users)(_.fullName.getOrElse(""))
    //    def articleiDFK = foreignKey("ARTICLE_ID_FK", articleID, articles)(_.id)
  }

  val commentsWithUsername = TableQuery[CommentsWithUsername]

  private val users = TableQuery[UserTable]

}

