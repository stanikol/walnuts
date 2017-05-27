package models.pages

import models.goods.{ BindingImageCategory, Category }
import slick.driver.PostgresDriver.api._
import slick.lifted.TableQuery

object PagesTableDef {

  /**
   * Created by snc on 5/6/17.
   */

  class Pages(tag: Tag) extends Table[Page](tag, "pages") {
    def url = column[String]("url", O.PrimaryKey)
    def lang = column[String]("lang")
    def title = column[String]("title")
    def html = column[String]("html")
    def keywords = column[String]("keywords")
    def description = column[String]("description")
    def * = (url, lang, title, html, keywords, description) <> (Page.tupled, Page.unapply)

  }

  val pages = TableQuery[Pages]

}
