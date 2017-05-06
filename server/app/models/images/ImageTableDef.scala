package models.images

//import models.blog.Data.Category
//import models.blog.BlogTablesDef.categories
import models.goods.{ BindingImageCategory, Category }
import slick.lifted.TableQuery
import slick.driver.PostgresDriver.api._
import models.blog.Data._

object ImageTableDef {

  /**
   * Created by snc on 5/6/17.
   */

  class Albums(tag: Tag) extends Table[Category](tag, "albums") {
    def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name")
    def sortOrder = column[String]("sort_order")
    def * = (id.?, name, sortOrder) <> (Category.tupled, Category.unapply)

    def nameIndex = index("name_index", name, unique = true)
  }

  val albums = TableQuery[Albums]

  class Images(tag: Tag) extends Table[Image](tag, "images") {
    def name = column[String]("name", O.PrimaryKey)
    def content = column[String]("content")
    def bytes = column[Option[Array[Byte]]]("bytes")
    def bytes150x150 = column[Option[Array[Byte]]]("bytes150x150")
    //    def albums = column[Option[List[String]]]("albums")
    def * = (name, content, bytes, bytes150x150) <> ((Image.apply _).tupled, Image.unapply)
  }
  val images = TableQuery[Images]

  class BindingImageCategoryTbl(tag: Tag) extends Table[BindingImageCategory](tag, "binding_image_album") {
    def imageName = column[String]("image_name")
    def categoryID = column[Int]("album_id")
    def * = (imageName, categoryID) <> (BindingImageCategory.tupled, BindingImageCategory.unapply)
    def imageNameFK = foreignKey("image_name_forein_key", imageName, images)(_.name)
    def categoryIDFK = foreignKey("album_id_forein_key", categoryID, albums)(_.id)
    def pk = primaryKey("pk_binding_image_album", (imageName, categoryID))
  }
  val bindingImageCategory = TableQuery[BindingImageCategoryTbl]
}
