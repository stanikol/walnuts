package utils

import scala.concurrent.{ ExecutionContext, Future }

/**
 * Created by snc on 5/22/17.
 */
class FutureOptionMonad[+A](val futureOptionA: Future[Option[A]]) {
  def flatMap[B](f: A => FutureOptionMonad[B])(implicit ec: ExecutionContext): FutureOptionMonad[B] = {
    new FutureOptionMonad(futureOptionA.flatMap {
      case Some(a) => f(a).futureOptionA
      case None => Future(None)
    })
  }

  def map[B](f: A => B)(implicit ec: ExecutionContext): FutureOptionMonad[B] =
    new FutureOptionMonad(futureOptionA.map(_.map(f)))
}

object FutureOptionMonad {
  implicit class AsFutureOptionMonad[A](val futureOptionA: Future[Option[A]]) {
    def asFutOptM: FutureOptionMonad[A] =
      new FutureOptionMonad[A](futureOptionA)
  }
}
