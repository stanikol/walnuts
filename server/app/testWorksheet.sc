import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

class FutureOptionMonad[+A](val oif: Future[Option[A]]) {
  def flatMap[B](f: A => FutureOptionMonad[B])(implicit ec: ExecutionContext): FutureOptionMonad[B] = {
    new FutureOptionMonad(oif.flatMap {
      case Some(a) => f(a).oif
      case None => Future(None)
    })
  }

  def map[B](f: A => B)(implicit ec: ExecutionContext): FutureOptionMonad[B] =
    new FutureOptionMonad(oif.map(_.map(f)))
}

implicit class AsFutureOptionMonad[A](val oif: Future[Option[A]]){
  def asFutOptM: FutureOptionMonad[A] =
    new FutureOptionMonad[A](oif)
}



val x1 = Future(Some(1))
val x2 = Future(Some(2))
val x3 = Future(None: Option[Int])

val myf = 
  for{
    xx1 <- x1.asFutOptM
    xx2 <- x2.asFutOptM
    xx3 <- x3.asFutOptM
  } yield xx1 + xx2

  Await.result(myf.oif, Duration.Inf)

