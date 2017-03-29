
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Thu Mar 30 01:46:36 EEST 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }

import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

// @LINE:27
package controllers {

  // @LINE:28
  class ReverseWebJarAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

    // @LINE:28
    def at(name: String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "webjars/" + implicitly[PathBindable[String]].unbind("name", name))
    }

  }

  // @LINE:27
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

    // @LINE:27
    def at(name: String): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("name", name))
    }

  }

}
