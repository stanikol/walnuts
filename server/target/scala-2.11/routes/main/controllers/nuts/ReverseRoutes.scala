
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Thu Mar 30 01:46:36 EEST 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }

import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

// @LINE:33
package controllers.nuts {

  // @LINE:52
  class ReverseComments(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

    // @LINE:55
    def loginOrSignUp(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "comments/loginOrSignUp")
    }

    // @LINE:52
    def addComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "comments/add")
    }

    // @LINE:53
    def editComment(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "comments/editComment")
    }

    // @LINE:54
    def commentsAdmin(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "comments/admin")
    }

  }

  // @LINE:60
  class ReverseGoods(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

    // @LINE:62
    def viewEditForm(id: Option[Long]): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "admin/items" + queryString(List(Some(implicitly[QueryStringBindable[Option[Long]]].unbind("id", id)))))
    }

    // @LINE:61
    def get(id: Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "index.php/items/view/id/" + implicitly[PathBindable[Long]].unbind("id", id))
    }

    // @LINE:60
    def listAllGoods(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "items")
    }

    // @LINE:63
    def updateOrCreateOrDelete(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "admin/items")
    }

  }

  // @LINE:33
  class ReverseImages(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

    // @LINE:36
    def edit(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "img/edit")
    }

    // @LINE:34
    def find(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "img/find")
    }

    // @LINE:35
    def list(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "img/list")
    }

    // @LINE:33
    def show(search: String = "", what: String = ""): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "img/show" + queryString(List(if (search == "") None else Some(implicitly[QueryStringBindable[String]].unbind("search", search)), if (what == "") None else Some(implicitly[QueryStringBindable[String]].unbind("what", what)))))
    }

    // @LINE:37
    def save(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "img/save")
    }

    // @LINE:38
    def get(name: String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "img/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
    }

  }

  // @LINE:43
  class ReverseBlog(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

    // @LINE:47
    def onSubmit(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "blog/submit")
    }

    // @LINE:43
    def showAllArticles(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "index.php/article")
    }

    // @LINE:45
    def create(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "blog/new")
    }

    // @LINE:46
    def edit(id: Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "blog/" + implicitly[PathBindable[Long]].unbind("id", id) + "/edit")
    }

    // @LINE:44
    def article(id: Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "index.php/article/view/id/" + implicitly[PathBindable[Long]].unbind("id", id))
    }

  }

}
