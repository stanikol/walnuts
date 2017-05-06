
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Sun May 07 01:48:52 EEST 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

// @LINE:39
package controllers.nuts {

  // @LINE:60
  class ReverseComments(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:63
    def loginOrSignUp(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "comments/loginOrSignUp")
    }
  
    // @LINE:61
    def addComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "admin/comments/add")
    }
  
    // @LINE:62
    def editComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "admin/comments/editComment")
    }
  
    // @LINE:60
    def commentsAdmin(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/comments")
    }
  
  }

  // @LINE:39
  class ReverseAdminCategories(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:40
    def adminAlbumsCategoriesHandle(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "admin/albums")
    }
  
    // @LINE:79
    def adminGoodsCategoriesHandle(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "admin/cats")
    }
  
    // @LINE:78
    def adminGoodsCategories(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/cats")
    }
  
    // @LINE:39
    def adminAlbumsCategories(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/albums")
    }
  
  }

  // @LINE:51
  class ReverseBlog(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:55
    def onSubmit(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "blog/submit")
    }
  
    // @LINE:51
    def showAllArticles(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "index.php/article")
    }
  
    // @LINE:53
    def create(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "blog/new")
    }
  
    // @LINE:54
    def edit(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "blog/" + implicitly[PathBindable[Long]].unbind("id", id) + "/edit")
    }
  
    // @LINE:52
    def article(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "index.php/article/view/id/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
  }

  // @LINE:73
  class ReverseImportData(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:75
    def importNuts(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/import-nuts")
    }
  
    // @LINE:76
    def importAll(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/import-all")
    }
  
    // @LINE:74
    def importArticles(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/import-articles")
    }
  
    // @LINE:73
    def importImages(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/import-images")
    }
  
  }


}
