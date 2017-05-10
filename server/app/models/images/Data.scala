package models.images

import java.io.File

import com.sksamuel.scrimage.{ Image => ScrImage }
import play.api.Logger
import play.api.libs.functional.syntax.{ unlift, _ }
import play.api.libs.json.{ Format, JsPath, Json }

/**
 * Created by snc on 5/6/17.
 */
// Image
case class Image(
  name: String,
  content: String
//  categories: Option[Seq[Int]]
//  bytes: Option[Array[Byte]],
//  bytes150x150: Option[Array[Byte]]
//    categories: Option[List[String]]
)

object Image {

  def empty = new Image("", "")

  def readImageFromFile(
    file: File,
    name: String,
    content: String,
    resizeTo: Option[(Int, Int)] = None
  ): Either[String, (Image, Array[Byte])] = {
    if (file.length() > 0) {
      Logger.info(s"readImageFromFile=> Reading ${file.getPath} ...")
      val scrImage = ScrImage.fromFile(file)
      val imageBytes: Array[Byte] = resizeTo.map {
        case (newHeight, newWidth) =>
          scrImage.scaleTo(newHeight, newWidth)
      }.getOrElse(scrImage).bytes
      val image = Image(name, content)
      Right((image, imageBytes))
    } else {
      val error = s"Ошибка ${file.getPath} пустой !"
      Logger.info(s"readImageFromFile=> $error")
      Left(error)
    }
  }
  //  implicit val imageJosn: Format[Image] = (
  //    (JsPath \ "name").format[String] and
  //    (JsPath \ "content").format[String] and
  //    (JsPath \ "bytes").format[Array[Byte]] and
  //    (JsPath \ "categories").format[Option[List[String]]]
  //  )(Image.apply _, unlift(Image.unapply(_)))
}

case class ImageBytes(name: String, bytes: Array[Byte])

case class ImageAlbums(name: String, albums: Seq[(Int, String)])

// ImageInfo
case class ImageInfo(name: String, content: String, categories: Option[String])

object ImageInfo {

  implicit class CategoriesToOptionString(s: Seq[(Int, String)]) {
    def toOptionString = {
      if (s.isEmpty) None
      else {
        s.map { case (i, n) => s"$i\t$n" }.mkString("\n") match {
          case str if str.isEmpty => None
          case str => Some(str)
        }
      }
    }
  }

  def apply(imageInfoWithAlbums: ImageInfoWithAlbums): ImageInfo = {
    new ImageInfo(
      imageInfoWithAlbums.name,
      imageInfoWithAlbums.content,
      imageInfoWithAlbums.categories.toOptionString
    )
  }
  def fromImage(image: Image): ImageInfo = new ImageInfo(image.name, image.content, None) //TODO: This `None` must not eixst !!!

  def splitCategoriesToSeq(s: String): Option[Seq[(Int, String)]] = {
    if (s.isEmpty) None
    else {
      Some(s.split("\\n").map(_.split("\\t")).map(i => i(0).toInt -> i(1)))
    }
  }

  implicit val imageInfoJson: Format[ImageInfo] = //Json.format[ImageInfo]
    (
      (JsPath \ "name").format[String] and
      (JsPath \ "content").format[String] and
      (JsPath \ "categories").formatNullable[String]
    )(ImageInfo.apply _, unlift(ImageInfo.unapply(_)))
}

case class ImageInfoWithAlbums(name: String, content: String, categories: Seq[(Int, String)])

object ImageInfoWithAlbums {
  def apply(ii: ImageInfo): ImageInfoWithAlbums = {
    val albums: Seq[(Int, String)] = try {
      ii.categories.getOrElse("").split("\n").map(_.split("\t")).map(a => a(0).toInt -> a(1))
    } catch {
      case e: Throwable => throw new Exception(s"ERROR with ${ii.categories}")
    }
    new ImageInfoWithAlbums(ii.name, ii.content, albums)
  }
}

