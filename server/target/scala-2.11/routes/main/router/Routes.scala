
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Wed Mar 29 17:21:32 EEST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.utils.route.Binders._

class Routes(
    override val errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ApplicationController_3: controllers.pages.ApplicationController,
    // @LINE:8
    SocialAuthController_4: controllers.auth.SocialAuthController,
    // @LINE:10
    SignUpController_9: controllers.auth.SignUpController,
    // @LINE:13
    SignInController_5: controllers.auth.SignInController,
    // @LINE:16
    ForgotPasswordController_0: controllers.auth.ForgotPasswordController,
    // @LINE:18
    ResetPasswordController_13: controllers.auth.ResetPasswordController,
    // @LINE:20
    ChangePasswordController_12: controllers.auth.ChangePasswordController,
    // @LINE:23
    ActivateAccountController_2: controllers.auth.ActivateAccountController,
    // @LINE:27
    Assets_10: controllers.Assets,
    // @LINE:28
    WebJarAssets_11: controllers.WebJarAssets,
    // @LINE:33
    Images_6: controllers.nuts.Images,
    // @LINE:43
    Blog_8: controllers.nuts.Blog,
    // @LINE:52
    Comments_1: controllers.nuts.Comments,
    // @LINE:60
    Goods_7: controllers.nuts.Goods,
    val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(
    errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ApplicationController_3: controllers.pages.ApplicationController,
    // @LINE:8
    SocialAuthController_4: controllers.auth.SocialAuthController,
    // @LINE:10
    SignUpController_9: controllers.auth.SignUpController,
    // @LINE:13
    SignInController_5: controllers.auth.SignInController,
    // @LINE:16
    ForgotPasswordController_0: controllers.auth.ForgotPasswordController,
    // @LINE:18
    ResetPasswordController_13: controllers.auth.ResetPasswordController,
    // @LINE:20
    ChangePasswordController_12: controllers.auth.ChangePasswordController,
    // @LINE:23
    ActivateAccountController_2: controllers.auth.ActivateAccountController,
    // @LINE:27
    Assets_10: controllers.Assets,
    // @LINE:28
    WebJarAssets_11: controllers.WebJarAssets,
    // @LINE:33
    Images_6: controllers.nuts.Images,
    // @LINE:43
    Blog_8: controllers.nuts.Blog,
    // @LINE:52
    Comments_1: controllers.nuts.Comments,
    // @LINE:60
    Goods_7: controllers.nuts.Goods
  ) = this(errorHandler, ApplicationController_3, SocialAuthController_4, SignUpController_9, SignInController_5, ForgotPasswordController_0, ResetPasswordController_13, ChangePasswordController_12, ActivateAccountController_2, Assets_10, WebJarAssets_11, Images_6, Blog_8, Comments_1, Goods_7, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ApplicationController_3, SocialAuthController_4, SignUpController_9, SignInController_5, ForgotPasswordController_0, ResetPasswordController_13, ChangePasswordController_12, ActivateAccountController_2, Assets_10, WebJarAssets_11, Images_6, Blog_8, Comments_1, Goods_7, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.pages.ApplicationController.index"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """signOut""", """controllers.pages.ApplicationController.signOut"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """authenticate/""" + "$" + """provider<[^/]+>""", """controllers.auth.SocialAuthController.authenticate(provider:String)"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """signUp""", """controllers.auth.SignUpController.view"""),
    ("""POST""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """signUp""", """controllers.auth.SignUpController.submit"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """signIn""", """controllers.auth.SignInController.view"""),
    ("""POST""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """signIn""", """controllers.auth.SignInController.submit"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """password/forgot""", """controllers.auth.ForgotPasswordController.view"""),
    ("""POST""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """password/forgot""", """controllers.auth.ForgotPasswordController.submit"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """password/reset/""" + "$" + """token<[^/]+>""", """controllers.auth.ResetPasswordController.view(token:java.util.UUID)"""),
    ("""POST""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """password/reset/""" + "$" + """token<[^/]+>""", """controllers.auth.ResetPasswordController.submit(token:java.util.UUID)"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """password/change""", """controllers.auth.ChangePasswordController.view"""),
    ("""POST""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """password/change""", """controllers.auth.ChangePasswordController.submit"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """account/email/""" + "$" + """email<[^/]+>""", """controllers.auth.ActivateAccountController.send(email:String)"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """account/activate/""" + "$" + """token<[^/]+>""", """controllers.auth.ActivateAccountController.activate(token:java.util.UUID)"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """name<.+>""", """controllers.Assets.at(path:String = "/public", name:String)"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """webjars/""" + "$" + """name<.+>""", """controllers.WebJarAssets.at(name:String)"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """img/show""", """controllers.nuts.Images.show(search:String ?= "", what:String ?= "")"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """img/find""", """controllers.nuts.Images.find"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """img/list""", """controllers.nuts.Images.list"""),
    ("""POST""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """img/edit""", """controllers.nuts.Images.edit"""),
    ("""POST""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """img/save""", """controllers.nuts.Images.save"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """img/""" + "$" + """name<[^/]+>""", """controllers.nuts.Images.get(name:String)"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """index.php/article""", """controllers.nuts.Blog.showAllArticles"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """index.php/article/view/id/""" + "$" + """id<[^/]+>""", """controllers.nuts.Blog.article(id:Long)"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """blog/new""", """controllers.nuts.Blog.create"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """blog/""" + "$" + """id<[^/]+>/edit""", """controllers.nuts.Blog.edit(id:Long)"""),
    ("""POST""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """blog/submit""", """controllers.nuts.Blog.onSubmit"""),
    ("""POST""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """comments/add""", """controllers.nuts.Comments.addComment"""),
    ("""POST""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """comments/editComment""", """controllers.nuts.Comments.editComment"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """comments/admin""", """controllers.nuts.Comments.commentsAdmin"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """comments/loginOrSignUp""", """controllers.nuts.Comments.loginOrSignUp"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """items""", """controllers.nuts.Goods.listAllGoods"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """index.php/items/view/id/""" + "$" + """id<[^/]+>""", """controllers.nuts.Goods.get(id:Long)"""),
    ("""GET""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """admin/items""", """controllers.nuts.Goods.viewEditForm(id:Option[Long])"""),
    ("""POST""", this.prefix + (if (this.prefix.endsWith("/")) "" else "/") + """admin/items""", """controllers.nuts.Goods.updateOrCreateOrDelete"""),
    Nil
  ).foldLeft(List.empty[(String, String, String)]) { (s, e) =>
      e.asInstanceOf[Any] match {
        case r @ (_, _, _) => s :+ r.asInstanceOf[(String, String, String)]
        case l => s ++ l.asInstanceOf[List[(String, String, String)]]
      }
    }

  // @LINE:6
  private[this] lazy val controllers_pages_ApplicationController_index0_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_pages_ApplicationController_index0_invoker = createInvoker(
    ApplicationController_3.index,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.pages.ApplicationController",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_pages_ApplicationController_signOut1_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signOut")))
  )
  private[this] lazy val controllers_pages_ApplicationController_signOut1_invoker = createInvoker(
    ApplicationController_3.signOut,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.pages.ApplicationController",
      "signOut",
      Nil,
      "GET",
      """""",
      this.prefix + """signOut"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_auth_SocialAuthController_authenticate2_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("authenticate/"), DynamicPart("provider", """[^/]+""", true)))
  )
  private[this] lazy val controllers_auth_SocialAuthController_authenticate2_invoker = createInvoker(
    SocialAuthController_4.authenticate(fakeValue[String]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.SocialAuthController",
      "authenticate",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """authenticate/""" + "$" + """provider<[^/]+>"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_auth_SignUpController_view3_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signUp")))
  )
  private[this] lazy val controllers_auth_SignUpController_view3_invoker = createInvoker(
    SignUpController_9.view,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.SignUpController",
      "view",
      Nil,
      "GET",
      """""",
      this.prefix + """signUp"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_auth_SignUpController_submit4_route = Route(
    "POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signUp")))
  )
  private[this] lazy val controllers_auth_SignUpController_submit4_invoker = createInvoker(
    SignUpController_9.submit,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.SignUpController",
      "submit",
      Nil,
      "POST",
      """""",
      this.prefix + """signUp"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_auth_SignInController_view5_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signIn")))
  )
  private[this] lazy val controllers_auth_SignInController_view5_invoker = createInvoker(
    SignInController_5.view,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.SignInController",
      "view",
      Nil,
      "GET",
      """""",
      this.prefix + """signIn"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_auth_SignInController_submit6_route = Route(
    "POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signIn")))
  )
  private[this] lazy val controllers_auth_SignInController_submit6_invoker = createInvoker(
    SignInController_5.submit,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.SignInController",
      "submit",
      Nil,
      "POST",
      """""",
      this.prefix + """signIn"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_auth_ForgotPasswordController_view7_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/forgot")))
  )
  private[this] lazy val controllers_auth_ForgotPasswordController_view7_invoker = createInvoker(
    ForgotPasswordController_0.view,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.ForgotPasswordController",
      "view",
      Nil,
      "GET",
      """""",
      this.prefix + """password/forgot"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_auth_ForgotPasswordController_submit8_route = Route(
    "POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/forgot")))
  )
  private[this] lazy val controllers_auth_ForgotPasswordController_submit8_invoker = createInvoker(
    ForgotPasswordController_0.submit,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.ForgotPasswordController",
      "submit",
      Nil,
      "POST",
      """""",
      this.prefix + """password/forgot"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_auth_ResetPasswordController_view9_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/reset/"), DynamicPart("token", """[^/]+""", true)))
  )
  private[this] lazy val controllers_auth_ResetPasswordController_view9_invoker = createInvoker(
    ResetPasswordController_13.view(fakeValue[java.util.UUID]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.ResetPasswordController",
      "view",
      Seq(classOf[java.util.UUID]),
      "GET",
      """""",
      this.prefix + """password/reset/""" + "$" + """token<[^/]+>"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_auth_ResetPasswordController_submit10_route = Route(
    "POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/reset/"), DynamicPart("token", """[^/]+""", true)))
  )
  private[this] lazy val controllers_auth_ResetPasswordController_submit10_invoker = createInvoker(
    ResetPasswordController_13.submit(fakeValue[java.util.UUID]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.ResetPasswordController",
      "submit",
      Seq(classOf[java.util.UUID]),
      "POST",
      """""",
      this.prefix + """password/reset/""" + "$" + """token<[^/]+>"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_auth_ChangePasswordController_view11_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/change")))
  )
  private[this] lazy val controllers_auth_ChangePasswordController_view11_invoker = createInvoker(
    ChangePasswordController_12.view,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.ChangePasswordController",
      "view",
      Nil,
      "GET",
      """""",
      this.prefix + """password/change"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_auth_ChangePasswordController_submit12_route = Route(
    "POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/change")))
  )
  private[this] lazy val controllers_auth_ChangePasswordController_submit12_invoker = createInvoker(
    ChangePasswordController_12.submit,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.ChangePasswordController",
      "submit",
      Nil,
      "POST",
      """""",
      this.prefix + """password/change"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_auth_ActivateAccountController_send13_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/email/"), DynamicPart("email", """[^/]+""", true)))
  )
  private[this] lazy val controllers_auth_ActivateAccountController_send13_invoker = createInvoker(
    ActivateAccountController_2.send(fakeValue[String]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.ActivateAccountController",
      "send",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """account/email/""" + "$" + """email<[^/]+>"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_auth_ActivateAccountController_activate14_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/activate/"), DynamicPart("token", """[^/]+""", true)))
  )
  private[this] lazy val controllers_auth_ActivateAccountController_activate14_invoker = createInvoker(
    ActivateAccountController_2.activate(fakeValue[java.util.UUID]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.auth.ActivateAccountController",
      "activate",
      Seq(classOf[java.util.UUID]),
      "GET",
      """""",
      this.prefix + """account/activate/""" + "$" + """token<[^/]+>"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_Assets_at15_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("name", """.+""", false)))
  )
  private[this] lazy val controllers_Assets_at15_invoker = createInvoker(
    Assets_10.at(fakeValue[String], fakeValue[String]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """name<.+>"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_WebJarAssets_at16_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("webjars/"), DynamicPart("name", """.+""", false)))
  )
  private[this] lazy val controllers_WebJarAssets_at16_invoker = createInvoker(
    WebJarAssets_11.at(fakeValue[String]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.WebJarAssets",
      "at",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """webjars/""" + "$" + """name<.+>"""
    )
  )

  // @LINE:33
  private[this] lazy val controllers_nuts_Images_show17_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("img/show")))
  )
  private[this] lazy val controllers_nuts_Images_show17_invoker = createInvoker(
    Images_6.show(fakeValue[String], fakeValue[String]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Images",
      "show",
      Seq(classOf[String], classOf[String]),
      "GET",
      """############################################
           Images in database              #
############################################""",
      this.prefix + """img/show"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_nuts_Images_find18_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("img/find")))
  )
  private[this] lazy val controllers_nuts_Images_find18_invoker = createInvoker(
    Images_6.find,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Images",
      "find",
      Nil,
      "GET",
      """""",
      this.prefix + """img/find"""
    )
  )

  // @LINE:35
  private[this] lazy val controllers_nuts_Images_list19_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("img/list")))
  )
  private[this] lazy val controllers_nuts_Images_list19_invoker = createInvoker(
    Images_6.list,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Images",
      "list",
      Nil,
      "GET",
      """""",
      this.prefix + """img/list"""
    )
  )

  // @LINE:36
  private[this] lazy val controllers_nuts_Images_edit20_route = Route(
    "POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("img/edit")))
  )
  private[this] lazy val controllers_nuts_Images_edit20_invoker = createInvoker(
    Images_6.edit,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Images",
      "edit",
      Nil,
      "POST",
      """""",
      this.prefix + """img/edit"""
    )
  )

  // @LINE:37
  private[this] lazy val controllers_nuts_Images_save21_route = Route(
    "POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("img/save")))
  )
  private[this] lazy val controllers_nuts_Images_save21_invoker = createInvoker(
    Images_6.save,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Images",
      "save",
      Nil,
      "POST",
      """""",
      this.prefix + """img/save"""
    )
  )

  // @LINE:38
  private[this] lazy val controllers_nuts_Images_get22_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("img/"), DynamicPart("name", """[^/]+""", true)))
  )
  private[this] lazy val controllers_nuts_Images_get22_invoker = createInvoker(
    Images_6.get(fakeValue[String]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Images",
      "get",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """img/""" + "$" + """name<[^/]+>"""
    )
  )

  // @LINE:43
  private[this] lazy val controllers_nuts_Blog_showAllArticles23_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index.php/article")))
  )
  private[this] lazy val controllers_nuts_Blog_showAllArticles23_invoker = createInvoker(
    Blog_8.showAllArticles,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Blog",
      "showAllArticles",
      Nil,
      "GET",
      """############################################
           Blog                            #
############################################""",
      this.prefix + """index.php/article"""
    )
  )

  // @LINE:44
  private[this] lazy val controllers_nuts_Blog_article24_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index.php/article/view/id/"), DynamicPart("id", """[^/]+""", true)))
  )
  private[this] lazy val controllers_nuts_Blog_article24_invoker = createInvoker(
    Blog_8.article(fakeValue[Long]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Blog",
      "article",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """index.php/article/view/id/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:45
  private[this] lazy val controllers_nuts_Blog_create25_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("blog/new")))
  )
  private[this] lazy val controllers_nuts_Blog_create25_invoker = createInvoker(
    Blog_8.create,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Blog",
      "create",
      Nil,
      "GET",
      """""",
      this.prefix + """blog/new"""
    )
  )

  // @LINE:46
  private[this] lazy val controllers_nuts_Blog_edit26_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("blog/"), DynamicPart("id", """[^/]+""", true), StaticPart("/edit")))
  )
  private[this] lazy val controllers_nuts_Blog_edit26_invoker = createInvoker(
    Blog_8.edit(fakeValue[Long]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Blog",
      "edit",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """blog/""" + "$" + """id<[^/]+>/edit"""
    )
  )

  // @LINE:47
  private[this] lazy val controllers_nuts_Blog_onSubmit27_route = Route(
    "POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("blog/submit")))
  )
  private[this] lazy val controllers_nuts_Blog_onSubmit27_invoker = createInvoker(
    Blog_8.onSubmit,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Blog",
      "onSubmit",
      Nil,
      "POST",
      """""",
      this.prefix + """blog/submit"""
    )
  )

  // @LINE:52
  private[this] lazy val controllers_nuts_Comments_addComment28_route = Route(
    "POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comments/add")))
  )
  private[this] lazy val controllers_nuts_Comments_addComment28_invoker = createInvoker(
    Comments_1.addComment,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Comments",
      "addComment",
      Nil,
      "POST",
      """############################################
           Comments                        #
############################################""",
      this.prefix + """comments/add"""
    )
  )

  // @LINE:53
  private[this] lazy val controllers_nuts_Comments_editComment29_route = Route(
    "POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comments/editComment")))
  )
  private[this] lazy val controllers_nuts_Comments_editComment29_invoker = createInvoker(
    Comments_1.editComment,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Comments",
      "editComment",
      Nil,
      "POST",
      """""",
      this.prefix + """comments/editComment"""
    )
  )

  // @LINE:54
  private[this] lazy val controllers_nuts_Comments_commentsAdmin30_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comments/admin")))
  )
  private[this] lazy val controllers_nuts_Comments_commentsAdmin30_invoker = createInvoker(
    Comments_1.commentsAdmin,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Comments",
      "commentsAdmin",
      Nil,
      "GET",
      """""",
      this.prefix + """comments/admin"""
    )
  )

  // @LINE:55
  private[this] lazy val controllers_nuts_Comments_loginOrSignUp31_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comments/loginOrSignUp")))
  )
  private[this] lazy val controllers_nuts_Comments_loginOrSignUp31_invoker = createInvoker(
    Comments_1.loginOrSignUp,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Comments",
      "loginOrSignUp",
      Nil,
      "GET",
      """""",
      this.prefix + """comments/loginOrSignUp"""
    )
  )

  // @LINE:60
  private[this] lazy val controllers_nuts_Goods_listAllGoods32_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("items")))
  )
  private[this] lazy val controllers_nuts_Goods_listAllGoods32_invoker = createInvoker(
    Goods_7.listAllGoods,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Goods",
      "listAllGoods",
      Nil,
      "GET",
      """############################################
           Goods                           #
############################################""",
      this.prefix + """items"""
    )
  )

  // @LINE:61
  private[this] lazy val controllers_nuts_Goods_get33_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index.php/items/view/id/"), DynamicPart("id", """[^/]+""", true)))
  )
  private[this] lazy val controllers_nuts_Goods_get33_invoker = createInvoker(
    Goods_7.get(fakeValue[Long]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Goods",
      "get",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """index.php/items/view/id/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:62
  private[this] lazy val controllers_nuts_Goods_viewEditForm34_route = Route(
    "GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/items")))
  )
  private[this] lazy val controllers_nuts_Goods_viewEditForm34_invoker = createInvoker(
    Goods_7.viewEditForm(fakeValue[Option[Long]]),
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Goods",
      "viewEditForm",
      Seq(classOf[Option[Long]]),
      "GET",
      """""",
      this.prefix + """admin/items"""
    )
  )

  // @LINE:63
  private[this] lazy val controllers_nuts_Goods_updateOrCreateOrDelete35_route = Route(
    "POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/items")))
  )
  private[this] lazy val controllers_nuts_Goods_updateOrCreateOrDelete35_invoker = createInvoker(
    Goods_7.updateOrCreateOrDelete,
    HandlerDef(
      this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Goods",
      "updateOrCreateOrDelete",
      Nil,
      "POST",
      """""",
      this.prefix + """admin/items"""
    )
  )

  def routes: PartialFunction[RequestHeader, Handler] = {

    // @LINE:6
    case controllers_pages_ApplicationController_index0_route(params) =>
      call {
        controllers_pages_ApplicationController_index0_invoker.call(ApplicationController_3.index)
      }

    // @LINE:7
    case controllers_pages_ApplicationController_signOut1_route(params) =>
      call {
        controllers_pages_ApplicationController_signOut1_invoker.call(ApplicationController_3.signOut)
      }

    // @LINE:8
    case controllers_auth_SocialAuthController_authenticate2_route(params) =>
      call(params.fromPath[String]("provider", None)) { (provider) =>
        controllers_auth_SocialAuthController_authenticate2_invoker.call(SocialAuthController_4.authenticate(provider))
      }

    // @LINE:10
    case controllers_auth_SignUpController_view3_route(params) =>
      call {
        controllers_auth_SignUpController_view3_invoker.call(SignUpController_9.view)
      }

    // @LINE:11
    case controllers_auth_SignUpController_submit4_route(params) =>
      call {
        controllers_auth_SignUpController_submit4_invoker.call(SignUpController_9.submit)
      }

    // @LINE:13
    case controllers_auth_SignInController_view5_route(params) =>
      call {
        controllers_auth_SignInController_view5_invoker.call(SignInController_5.view)
      }

    // @LINE:14
    case controllers_auth_SignInController_submit6_route(params) =>
      call {
        controllers_auth_SignInController_submit6_invoker.call(SignInController_5.submit)
      }

    // @LINE:16
    case controllers_auth_ForgotPasswordController_view7_route(params) =>
      call {
        controllers_auth_ForgotPasswordController_view7_invoker.call(ForgotPasswordController_0.view)
      }

    // @LINE:17
    case controllers_auth_ForgotPasswordController_submit8_route(params) =>
      call {
        controllers_auth_ForgotPasswordController_submit8_invoker.call(ForgotPasswordController_0.submit)
      }

    // @LINE:18
    case controllers_auth_ResetPasswordController_view9_route(params) =>
      call(params.fromPath[java.util.UUID]("token", None)) { (token) =>
        controllers_auth_ResetPasswordController_view9_invoker.call(ResetPasswordController_13.view(token))
      }

    // @LINE:19
    case controllers_auth_ResetPasswordController_submit10_route(params) =>
      call(params.fromPath[java.util.UUID]("token", None)) { (token) =>
        controllers_auth_ResetPasswordController_submit10_invoker.call(ResetPasswordController_13.submit(token))
      }

    // @LINE:20
    case controllers_auth_ChangePasswordController_view11_route(params) =>
      call {
        controllers_auth_ChangePasswordController_view11_invoker.call(ChangePasswordController_12.view)
      }

    // @LINE:21
    case controllers_auth_ChangePasswordController_submit12_route(params) =>
      call {
        controllers_auth_ChangePasswordController_submit12_invoker.call(ChangePasswordController_12.submit)
      }

    // @LINE:23
    case controllers_auth_ActivateAccountController_send13_route(params) =>
      call(params.fromPath[String]("email", None)) { (email) =>
        controllers_auth_ActivateAccountController_send13_invoker.call(ActivateAccountController_2.send(email))
      }

    // @LINE:24
    case controllers_auth_ActivateAccountController_activate14_route(params) =>
      call(params.fromPath[java.util.UUID]("token", None)) { (token) =>
        controllers_auth_ActivateAccountController_activate14_invoker.call(ActivateAccountController_2.activate(token))
      }

    // @LINE:27
    case controllers_Assets_at15_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("name", None)) { (path, name) =>
        controllers_Assets_at15_invoker.call(Assets_10.at(path, name))
      }

    // @LINE:28
    case controllers_WebJarAssets_at16_route(params) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_WebJarAssets_at16_invoker.call(WebJarAssets_11.at(name))
      }

    // @LINE:33
    case controllers_nuts_Images_show17_route(params) =>
      call(params.fromQuery[String]("search", Some("")), params.fromQuery[String]("what", Some(""))) { (search, what) =>
        controllers_nuts_Images_show17_invoker.call(Images_6.show(search, what))
      }

    // @LINE:34
    case controllers_nuts_Images_find18_route(params) =>
      call {
        controllers_nuts_Images_find18_invoker.call(Images_6.find)
      }

    // @LINE:35
    case controllers_nuts_Images_list19_route(params) =>
      call {
        controllers_nuts_Images_list19_invoker.call(Images_6.list)
      }

    // @LINE:36
    case controllers_nuts_Images_edit20_route(params) =>
      call {
        controllers_nuts_Images_edit20_invoker.call(Images_6.edit)
      }

    // @LINE:37
    case controllers_nuts_Images_save21_route(params) =>
      call {
        controllers_nuts_Images_save21_invoker.call(Images_6.save)
      }

    // @LINE:38
    case controllers_nuts_Images_get22_route(params) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_nuts_Images_get22_invoker.call(Images_6.get(name))
      }

    // @LINE:43
    case controllers_nuts_Blog_showAllArticles23_route(params) =>
      call {
        controllers_nuts_Blog_showAllArticles23_invoker.call(Blog_8.showAllArticles)
      }

    // @LINE:44
    case controllers_nuts_Blog_article24_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_nuts_Blog_article24_invoker.call(Blog_8.article(id))
      }

    // @LINE:45
    case controllers_nuts_Blog_create25_route(params) =>
      call {
        controllers_nuts_Blog_create25_invoker.call(Blog_8.create)
      }

    // @LINE:46
    case controllers_nuts_Blog_edit26_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_nuts_Blog_edit26_invoker.call(Blog_8.edit(id))
      }

    // @LINE:47
    case controllers_nuts_Blog_onSubmit27_route(params) =>
      call {
        controllers_nuts_Blog_onSubmit27_invoker.call(Blog_8.onSubmit)
      }

    // @LINE:52
    case controllers_nuts_Comments_addComment28_route(params) =>
      call {
        controllers_nuts_Comments_addComment28_invoker.call(Comments_1.addComment)
      }

    // @LINE:53
    case controllers_nuts_Comments_editComment29_route(params) =>
      call {
        controllers_nuts_Comments_editComment29_invoker.call(Comments_1.editComment)
      }

    // @LINE:54
    case controllers_nuts_Comments_commentsAdmin30_route(params) =>
      call {
        controllers_nuts_Comments_commentsAdmin30_invoker.call(Comments_1.commentsAdmin)
      }

    // @LINE:55
    case controllers_nuts_Comments_loginOrSignUp31_route(params) =>
      call {
        controllers_nuts_Comments_loginOrSignUp31_invoker.call(Comments_1.loginOrSignUp)
      }

    // @LINE:60
    case controllers_nuts_Goods_listAllGoods32_route(params) =>
      call {
        controllers_nuts_Goods_listAllGoods32_invoker.call(Goods_7.listAllGoods)
      }

    // @LINE:61
    case controllers_nuts_Goods_get33_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_nuts_Goods_get33_invoker.call(Goods_7.get(id))
      }

    // @LINE:62
    case controllers_nuts_Goods_viewEditForm34_route(params) =>
      call(params.fromQuery[Option[Long]]("id", None)) { (id) =>
        controllers_nuts_Goods_viewEditForm34_invoker.call(Goods_7.viewEditForm(id))
      }

    // @LINE:63
    case controllers_nuts_Goods_updateOrCreateOrDelete35_route(params) =>
      call {
        controllers_nuts_Goods_updateOrCreateOrDelete35_invoker.call(Goods_7.updateOrCreateOrDelete)
      }
  }
}
