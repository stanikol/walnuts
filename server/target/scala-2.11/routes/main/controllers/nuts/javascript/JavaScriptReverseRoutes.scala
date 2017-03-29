
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Thu Mar 30 01:46:36 EEST 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }

import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

// @LINE:33
package controllers.nuts.javascript {
  import ReverseRouteContext.empty

  // @LINE:52
  class ReverseComments(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

    // @LINE:55
    def loginOrSignUp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Comments.loginOrSignUp",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comments/loginOrSignUp"})
        }
      """
    )

    // @LINE:52
    def addComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Comments.addComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "comments/add"})
        }
      """
    )

    // @LINE:53
    def editComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Comments.editComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "comments/editComment"})
        }
      """
    )

    // @LINE:54
    def commentsAdmin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Comments.commentsAdmin",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comments/admin"})
        }
      """
    )

  }

  // @LINE:60
  class ReverseGoods(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

    // @LINE:62
    def viewEditForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Goods.viewEditForm",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/items" + _qS([(""" + implicitly[QueryStringBindable[Option[Long]]].javascriptUnbind + """)("id", id0)])})
        }
      """
    )

    // @LINE:61
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Goods.get",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index.php/items/view/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )

    // @LINE:60
    def listAllGoods: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Goods.listAllGoods",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "items"})
        }
      """
    )

    // @LINE:63
    def updateOrCreateOrDelete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Goods.updateOrCreateOrDelete",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/items"})
        }
      """
    )

  }

  // @LINE:33
  class ReverseImages(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

    // @LINE:36
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

    // @LINE:35
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Images.list",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "img/list"})
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

    // @LINE:37
    def save: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Images.save",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "img/save"})
        }
      """
    )

    // @LINE:38
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Images.get",
      """
        function(name0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "img/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name0))})
        }
      """
    )

  }

  // @LINE:43
  class ReverseBlog(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

    // @LINE:47
    def onSubmit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.onSubmit",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "blog/submit"})
        }
      """
    )

    // @LINE:43
    def showAllArticles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.showAllArticles",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index.php/article"})
        }
      """
    )

    // @LINE:45
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.create",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "blog/new"})
        }
      """
    )

    // @LINE:46
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
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index.php/article/view/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )

  }

}
