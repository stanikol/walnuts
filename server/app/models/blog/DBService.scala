//package models.nuts
//
///**
// * Created by stanikol on 1/27/17.
// */
//
//import javax.inject.{ Inject, Singleton }
//import scala.concurrent.Future
//import scala.concurrent.Await
//import scala.concurrent.duration.Duration
//import com.google.inject.ImplementedBy
//import play.api.db.slick.DatabaseConfigProvider
//import slick.dbio.{ DBIOAction, NoStream }
//import slick.driver.JdbcProfile
//
//@ImplementedBy(classOf[DBServiceImpl])
//trait DBService {
//  def runAsync[R](a: DBIOAction[R, NoStream, Nothing]): Future[R]
//
//  def run[R](a: DBIOAction[R, NoStream, Nothing], duration: Duration = Duration.Inf): R
//}
//
//@Singleton
//class DBServiceImpl @Inject() (val dbConfigProvider: DatabaseConfigProvider) extends DBService {
//  private val db = dbConfigProvider.get[JdbcProfile].db
//
//  def runAsync[R](a: DBIOAction[R, NoStream, Nothing]): Future[R] = {
//    db.run(a)
//  }
//
//  def run[R](a: DBIOAction[R, NoStream, Nothing], duration: Duration = Duration.Inf): R = {
//    Await.result(runAsync(a), duration)
//  }
//
//}
//
