package utils

import javax.inject.Inject

import akka.stream.Materializer
import play.api.{ Logger => Log }
import play.api.http.HttpFilters
import play.api.mvc.{ EssentialFilter, Filter, RequestHeader, Result }
import play.filters.csrf.CSRFFilter
import play.filters.headers.SecurityHeadersFilter

import scala.concurrent.{ ExecutionContext, Future }

/**
 * Provides filters.
 */
class Filters @Inject() (implicit csrfFilter: CSRFFilter, securityHeadersFilter: SecurityHeadersFilter, val mat: Materializer, val ec: ExecutionContext) extends HttpFilters {
  val loggingFilter = new LoggingFilter
  override def filters: Seq[EssentialFilter] = Seq(csrfFilter, securityHeadersFilter, loggingFilter)
}

class LoggingFilter @Inject() (implicit val mat: Materializer, ec: ExecutionContext) extends Filter {

  def apply(nextFilter: RequestHeader => Future[Result])(requestHeader: RequestHeader): Future[Result] = {

    val startTime = System.currentTimeMillis

    nextFilter(requestHeader).map { result =>

      val endTime = System.currentTimeMillis
      val requestTime = endTime - startTime

      Log.info(s"${requestHeader.method} ${requestHeader.uri} took ${requestTime}ms and returned ${result.header.status} contentLength=${result.body.contentLength} contentType=${result.body.contentType}.")

      result.withHeaders("Request-Time" -> requestTime.toString)
    }
  }
}

