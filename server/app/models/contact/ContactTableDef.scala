package models.contact

import slick.lifted.TableQuery
//import play.api.http.ContentTypes
//import play.api.libs.json._
//import play.api.libs.functional.syntax._
import slick.driver.PostgresDriver.api._
//import MyPostgresDriver.api._

/**
 * Created by snc on 5/6/17.
 */
object ContactTableDef {

  class ContactTable(tag: Tag) extends Table[Contact](tag, "contact") {
    def phones = column[String]("phones")
    def email = column[String]("email")
    def city = column[String]("city")
    def address = column[String]("address")
    def www = column[String]("www")
    def * = (phones, email, city, address, www) <> (Contact.tupled, Contact.unapply)
  }

  val contactTQ = TableQuery[ContactTable]

  class RichContactTable(tag: Tag) extends Table[RichContact](tag, "rich_contact") {
    def html = column[String]("html")
    def * = (html) <> ((RichContact.apply _), RichContact.unapply)
  }

  val richContactTQ = TableQuery[RichContactTable]

}

