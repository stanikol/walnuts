package models.images

import java.io.File

import com.sksamuel.scrimage.{ Image => ScrImage }
import play.api.Logger
import play.api.libs.functional.syntax.{ unlift, _ }
import play.api.libs.json.{ Format, JsPath }

/**
 * Created by snc on 5/6/17.
 */
// Image
case class Image(
  name: String,
  content: String,
  bytes: Option[Array[Byte]],
  bytes150x150: Option[Array[Byte]]
//    categories: Option[List[String]]
)

object Image {

  def empty = new Image("", "", None, None)

  def readImageFromFile(file: File, name: String, content: String, resizeTo: Option[(Int, Int)] = None): Image = {
    if (file.length() > 0) {
      Logger.info(s"readImageFromFile=> Reading ${file.getPath} ...")
      val scrImage = ScrImage.fromFile(file)
      val imageBytes: Array[Byte] = resizeTo.map {
        case (newHeight, newWidth) =>
          scrImage.scaleTo(newHeight, newWidth)
      }.getOrElse(scrImage).bytes
      val thumbnailBytes = scrImage.scaleTo(150, 150).bytes
      val image = Image(name, content, Some(imageBytes), Some(thumbnailBytes))
      image
    } else {
      Logger.info(s"readImageFromFile=> ${file.getPath} is empty !")
      Image(name, content, None, None)
    }
  }
  //  implicit val imageJosn: Format[Image] = (
  //    (JsPath \ "name").format[String] and
  //    (JsPath \ "content").format[String] and
  //    (JsPath \ "bytes").format[Array[Byte]] and
  //    (JsPath \ "categories").format[Option[List[String]]]
  //  )(Image.apply _, unlift(Image.unapply(_)))
}

// ImageInfo
case class ImageInfo(name: String, content: String, categories: Option[Seq[Int]])

object ImageInfo {
  def fromImage(image: Image): ImageInfo = new ImageInfo(image.name, image.content, None) //TODO: This `None` must not eixst !!!

  implicit val imageInfoJson: Format[ImageInfo] = //Json.format[ImageInfo]
    (
      (JsPath \ "name").format[String] and
      (JsPath \ "content").format[String] and
      (JsPath \ "categories").formatNullable[Seq[Int]]
    )(ImageInfo.apply _, unlift(ImageInfo.unapply(_)))
}

