
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Sun May 07 01:48:52 EEST 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

// @LINE:39
package controllers.nuts.javascript {
  import ReverseRouteContext.empty

  // @LINE:60
  class ReverseComments(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:63
    def loginOrSignUp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Comments.loginOrSignUp",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "comments/loginOrSignUp"})
        }
      """
    )
  
    // @LINE:61
    def addComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Comments.addComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/comments/add"})
        }
      """
    )
  
    // @LINE:62
    def editComment: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Comments.editComment",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/comments/editComment"})
        }
      """
    )
  
    // @LINE:60
    def commentsAdmin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Comments.commentsAdmin",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/comments"})
        }
      """
    )
  
  }

  // @LINE:39
  class ReverseAdminCategories(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:40
    def adminAlbumsCategoriesHandle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.AdminCategories.adminAlbumsCategoriesHandle",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/albums"})
        }
      """
    )
  
    // @LINE:79
    def adminGoodsCategoriesHandle: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.AdminCategories.adminGoodsCategoriesHandle",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/cats"})
        }
      """
    )
  
    // @LINE:78
    def adminGoodsCategories: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.AdminCategories.adminGoodsCategories",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/cats"})
        }
      """
    )
  
    // @LINE:39
    def adminAlbumsCategories: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.AdminCategories.adminAlbumsCategories",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/albums"})
        }
      """
    )
  
  }

  // @LINE:51
  class ReverseBlog(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:55
    def onSubmit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.onSubmit",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "blog/submit"})
        }
      """
    )
  
    // @LINE:51
    def showAllArticles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.showAllArticles",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index.php/article"})
        }
      """
    )
  
    // @LINE:53
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.create",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "blog/new"})
        }
      """
    )
  
    // @LINE:54
    def edit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.edit",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "blog/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0) + "/edit"})
        }
      """
    )
  
    // @LINE:52
    def article: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.Blog.article",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index.php/article/view/id/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
  }

  // @LINE:73
  class ReverseImportData(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:75
    def importNuts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.ImportData.importNuts",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/import-nuts"})
        }
      """
    )
  
    // @LINE:76
    def importAll: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.ImportData.importAll",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/import-all"})
        }
      """
    )
  
    // @LINE:74
    def importArticles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.ImportData.importArticles",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/import-articles"})
        }
      """
    )
  
    // @LINE:73
    def importImages: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.nuts.ImportData.importImages",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "admin/import-images"})
        }
      """
    )
  
  }


}
