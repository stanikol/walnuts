package models.blog

/**
 * Created by stanikol on 1/27/17.
 */

import java.sql.Timestamp

import models.tables.UserTable
import slick.lifted.TableQuery
import slick.driver.PostgresDriver.api._
import models.blog.Data._
/**
 * Created by stanikol on 10/21/16.
 */

object BlogTablesDef {

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

