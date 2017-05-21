package grab

import java.io.File
import javax.inject.{Inject, _}

import com.google.inject.{AbstractModule, Guice}
import models.images._
import play.api.Logger
import play.api.inject.Injector
/**
 * Created by snc on 4/27/17.
 */
//
//trait PlayInjector {
//  lazy val injector = new GuiceInjectorBuilder().configure(Configuration.load(Environment.simple(mode = Mode.Dev)))
//    .bindings(new SlickModule).disable(classOf[Application]).injector
//
//  def closeInjector = injector.instanceOf[DefaultApplicationLifecycle].stop
//}

object GrabRead extends App {

  def getFileTree(f: File): Stream[File] =
    f #:: (if (f.isDirectory) f.listFiles().toStream.flatMap(getFileTree)
    else Stream.empty)

  def readImagesFromDir(f: File): Stream[(Image, Array[Byte])] = {
    val imageFiles = getFileTree(f).filter(file =>
      //      file.isFile && !List(".html", ".tsv").contains(file.getName.endsWith(_)))
      file.isFile && Seq(".jpg", ".png").exists(file.getName.endsWith(_)))
    imageFiles.map { file =>
      Logger.info(s"Reading image ${file.getPath} ${file.getAbsolutePath}...")
      Image.readImageFromFile(file, file.getName, "", None) match {
        case Left(error) =>
          throw new Exception(s"Error reading file ${file.getPath}")
        case Right(res @ (img, bytes)) => res
      }
    }
  }

  //println(readImagesFromDir(new File("grab")).toList.mkString("\n"))

}
