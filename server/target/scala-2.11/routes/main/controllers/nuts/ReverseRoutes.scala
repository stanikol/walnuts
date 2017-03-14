
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Wed Mar 15 00:23:29 EET 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

// @LINE:33
package controllers.nuts {

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
    def show(search:String = "", what:String = ""): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "img/show" + queryString(List(if(search == "") None else Some(implicitly[QueryStringBindable[String]].unbind("search", search)), if(what == "") None else Some(implicitly[QueryStringBindable[String]].unbind("what", what)))))
    }
  
    // @LINE:37
    def save(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "img/save")
    }
  
    // @LINE:38
    def get(name:String): Call = {
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
      Call("GET", _prefix + { _defaultPrefix } + "blog")
    }
  
    // @LINE:44
    def create(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "blog/new")
    }
  
    // @LINE:46
    def edit(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "blog/" + implicitly[PathBindable[Long]].unbind("id", id) + "/edit")
    }
  
    // @LINE:45
    def article(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "blog/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
  }


}
