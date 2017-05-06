package models.contact

/**
 * Created by snc on 5/6/17.
 */

case class Contact(phones: String, email: String, city: String, address: String, www: String)

case class RichContact(html: String)
