package models.blog

import java.sql.Timestamp

import com.sksamuel.scrimage.{ Image => ScrImage }
/**
 * Created by stanikol on 1/27/17.
 */
object Data {

  // Article
  case class Article(
    id: Option[Long],
    sort_order: String,
    keywords: String,
    title: String,
    text: String,
    description: String,
    short_text: String
  )

  object Article {
    def empty: Article = Article(None, "", "", "", "", "", "")
  }

  case class Comment(id: Option[Long], userID: String, articleID: Long, text: String, added: Timestamp)
  case class CommentInfo(id: Option[Long], userID: String, userEmail: Option[String], articleID: Long, articleTitle: String, text: String, added: Timestamp, fullName: String)

  case class CommentsShow(order: Option[String], articleID: Option[String])

}
