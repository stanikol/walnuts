package models.blog

import java.time.{ LocalDate, LocalDateTime, LocalTime }
import java.util.Date
import javax.inject.Inject

import models.User
import models.blog.Data.{ Article, Comment, CommentInfo, CommentsShow }
import models.blog.BlogTablesDef._
import play.api.db.slick.DatabaseConfigProvider
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend
import slick.model.Column

import scala.concurrent.Future

/**
 * Created by snc on 2/25/17.
 */
class CommentsDAO @Inject() (dbConfigProvider: DatabaseConfigProvider) {

  private val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  private val db: JdbcBackend#DatabaseDef = dbConfig.db
  import dbConfig.driver.api._

  def getComments(articleID: Long): Future[Seq[CommentInfo]] = db.run(commentsWithUsername.filter(_.articleID === articleID).result)

  def newComment(articleID: Long, comment: String, user: User) = {
    val addCommentQry = comments += Comment(None, user.userID.toString, articleID, comment, java.sql.Timestamp.valueOf(LocalDateTime.now()))

    db.run(addCommentQry)
  }

  def deleteComment(commentID: Long) = db.run(comments.filter(_.id === commentID).delete)

  def updateCommentText(commentID: Long, commentText: String) = db.run(
    comments.filter(_.id === commentID).map(_.text).update(commentText)
  )

  def listAll(commentsShow: CommentsShow): Future[Seq[CommentInfo]] = {
    val qry = commentsWithUsername.filter { c =>
      commentsShow.articleID match {
        case None => true: Rep[Boolean]
        case Some(id) => c.articleID === id.toLong
      }
    }
    db.run(commentsShow.order match {
      case Some("byArticle") => qry.sortBy(c => (c.articleID.desc, c.added.desc, c.id.desc)).result
      case _ => qry.sortBy(c => (c.added.desc, c.id.desc)).result
    })
  }

}
