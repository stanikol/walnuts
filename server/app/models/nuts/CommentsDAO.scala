package models.nuts

import java.time.{ LocalDate, LocalDateTime, LocalTime }
import java.util.Date
import javax.inject.Inject

import models.User
import models.nuts.Data.{ Article, Comment, CommentInfo }
import models.nuts.Tables._
import play.api.db.slick.DatabaseConfigProvider
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile
import slick.jdbc.JdbcBackend
import slick.model.Table

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

  def listAll(commentsOrder: Option[String]): Future[Seq[CommentInfo]] = {
    val qry = commentsOrder match {
      case Some("byArticle") => commentsWithUsername.sortBy(c => (c.articleID.desc, c.added.desc, c.id.desc)).result
      case _ => commentsWithUsername.sortBy(c => (c.added.desc, c.id.desc)).result
    }
    db.run(qry)
  }

}
