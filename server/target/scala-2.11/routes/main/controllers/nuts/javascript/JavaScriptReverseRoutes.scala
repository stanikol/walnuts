
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Sun Feb 19 00:58:08 EET 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

// @LINE:33
package controllers.nuts.javascript {
  import ReverseRouteContext.empty

  // @LINE:33
  class ReverseImages(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:35
    def edit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Images.edit",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "img/edit"})
        }
      """
    )
  
    // @LINE:34
    def find: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Images.find",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "img/find"})
        }
      """
    )
  
    // @LINE:33
    def show: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Images.show",
      """
        function(search0,what1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "img/show" + _qS([(search0 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("search", search0)), (what1 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("what", what1))])})
        }
      """
    )
  
    // @LINE:36
    def save: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Images.save",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "img/save"})
        }
      """
    )
  
    // @LINE:37
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Images.get",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "img/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name0))})
        }
      """
    )
  
  }

  // @LINE:42
  class ReverseBlog(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:46
    def onSubmit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.onSubmit",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "blog/submit"})
        }
      """
    )
  
    // @LINE:42
    def showAllArticles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.showAllArticles",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "blog"})
        }
      """
    )
  
    // @LINE:43
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.create",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "blog/new"})
        }
      """
    )
  
    // @LINE:45
    def edit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.edit",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "blog/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0) + "/edit"})
        }
      """
    )
  
    // @LINE:44
    def article: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.article",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "blog/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
  }


}
