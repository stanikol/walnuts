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
    def * = (name, content) <> ((Image.apply _).tupled, Image.unapply)
  }
  val images = TableQuery[Images]

  class BindingImageCategoryTbl(tag: Tag) extends Table[BindingImageCategory](tag, "binding_image_album") {
    def imageName = column[String]("image_name")
    def categoryID = column[Int]("album_id")
    def * = (imageName, categoryID) <> (BindingImageCategory.tupled, BindingImageCategory.unapply)
    def imageNameFK = foreignKey("binding_image_album_image_name_fkey", imageName, images)(_.name)
    def categoryIDFK = foreignKey("binding_image_album_album_id_fkey", categoryID, albums)(_.id)
    def pk = index("binding_image_album_unique", (imageName, categoryID), unique = true)
  }
  val bindingImageCategory = TableQuery[BindingImageCategoryTbl]

  class ImageBytesTbl(tag: Tag) extends Table[ImageBytes](tag, "image_bytes") {
    def imageName = column[String]("image_name", O.PrimaryKey)
    def bytes = column[Array[Byte]]("bytes")
    def * = (imageName, bytes) <> (ImageBytes.tupled, ImageBytes.unapply)
    def imageNameFK = foreignKey("image_bytes_image_name_fkey", imageName, images)(_.name)
  }
  val imageBytes = TableQuery[ImageBytesTbl]

  class ThumbnailBytesTbl(tag: Tag) extends Table[ImageBytes](tag, "image_thumbnail_bytes") {
    def imageName = column[String]("image_name", O.PrimaryKey)
    def bytes = column[Array[Byte]]("bytes")
    def * = (imageName, bytes) <> (ImageBytes.tupled, ImageBytes.unapply)
    def imageNameFK = foreignKey("image_thumbnail_bytes_image_name_fkey", imageName, images)(_.name)
  }
  val thumbnailBytes = TableQuery[ThumbnailBytesTbl]

  class ImageInfoTbl(tag: Tag) extends Table[ImageInfo](tag, "image_info") {
    def name = column[String]("name", O.PrimaryKey)
    def content = column[String]("content")
    def categories = column[Option[String]]("categories")
    def * = (name, content, categories) <> ((ImageInfo.apply(_: String, _: String, _: Option[String])).tupled, ImageInfo.unapply)
  }
  val imageInfos = TableQuery[ImageInfoTbl]

}
