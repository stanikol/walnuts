
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Sun May 07 01:48:52 EEST 2017

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
  ApplicationController_5: controllers.pages.ApplicationController,
  // @LINE:8
  SocialAuthController_6: controllers.auth.SocialAuthController,
  // @LINE:10
  SignUpController_11: controllers.auth.SignUpController,
  // @LINE:13
  SignInController_8: controllers.auth.SignInController,
  // @LINE:16
  ForgotPasswordController_0: controllers.auth.ForgotPasswordController,
  // @LINE:18
  ResetPasswordController_15: controllers.auth.ResetPasswordController,
  // @LINE:20
  ChangePasswordController_14: controllers.auth.ChangePasswordController,
  // @LINE:23
  ActivateAccountController_4: controllers.auth.ActivateAccountController,
  // @LINE:28
  WebJarAssets_13: controllers.WebJarAssets,
  // @LINE:33
  Images_2: controllers.images.Images,
  // @LINE:39
  AdminCategories_7: controllers.nuts.AdminCategories,
  // @LINE:51
  Blog_10: controllers.nuts.Blog,
  // @LINE:60
  Comments_1: controllers.nuts.Comments,
  // @LINE:68
  Goods_9: controllers.goods.Goods,
  // @LINE:73
  ImportData_3: controllers.nuts.ImportData,
  // @LINE:83
  Assets_12: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    ApplicationController_5: controllers.pages.ApplicationController,
    // @LINE:8
    SocialAuthController_6: controllers.auth.SocialAuthController,
    // @LINE:10
    SignUpController_11: controllers.auth.SignUpController,
    // @LINE:13
    SignInController_8: controllers.auth.SignInController,
    // @LINE:16
    ForgotPasswordController_0: controllers.auth.ForgotPasswordController,
    // @LINE:18
    ResetPasswordController_15: controllers.auth.ResetPasswordController,
    // @LINE:20
    ChangePasswordController_14: controllers.auth.ChangePasswordController,
    // @LINE:23
    ActivateAccountController_4: controllers.auth.ActivateAccountController,
    // @LINE:28
    WebJarAssets_13: controllers.WebJarAssets,
    // @LINE:33
    Images_2: controllers.images.Images,
    // @LINE:39
    AdminCategories_7: controllers.nuts.AdminCategories,
    // @LINE:51
    Blog_10: controllers.nuts.Blog,
    // @LINE:60
    Comments_1: controllers.nuts.Comments,
    // @LINE:68
    Goods_9: controllers.goods.Goods,
    // @LINE:73
    ImportData_3: controllers.nuts.ImportData,
    // @LINE:83
    Assets_12: controllers.Assets
  ) = this(errorHandler, ApplicationController_5, SocialAuthController_6, SignUpController_11, SignInController_8, ForgotPasswordController_0, ResetPasswordController_15, ChangePasswordController_14, ActivateAccountController_4, WebJarAssets_13, Images_2, AdminCategories_7, Blog_10, Comments_1, Goods_9, ImportData_3, Assets_12, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ApplicationController_5, SocialAuthController_6, SignUpController_11, SignInController_8, ForgotPasswordController_0, ResetPasswordController_15, ChangePasswordController_14, ActivateAccountController_4, WebJarAssets_13, Images_2, AdminCategories_7, Blog_10, Comments_1, Goods_9, ImportData_3, Assets_12, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.pages.ApplicationController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signOut""", """controllers.pages.ApplicationController.signOut"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """authenticate/""" + "$" + """provider<[^/]+>""", """controllers.auth.SocialAuthController.authenticate(provider:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signUp""", """controllers.auth.SignUpController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signUp""", """controllers.auth.SignUpController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signIn""", """controllers.auth.SignInController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signIn""", """controllers.auth.SignInController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/forgot""", """controllers.auth.ForgotPasswordController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/forgot""", """controllers.auth.ForgotPasswordController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/reset/""" + "$" + """token<[^/]+>""", """controllers.auth.ResetPasswordController.view(token:java.util.UUID)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/reset/""" + "$" + """token<[^/]+>""", """controllers.auth.ResetPasswordController.submit(token:java.util.UUID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/change""", """controllers.auth.ChangePasswordController.view"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """password/change""", """controllers.auth.ChangePasswordController.submit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/email/""" + "$" + """email<[^/]+>""", """controllers.auth.ActivateAccountController.send(email:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """account/activate/""" + "$" + """token<[^/]+>""", """controllers.auth.ActivateAccountController.activate(token:java.util.UUID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """webjars/""" + "$" + """name<.+>""", """controllers.WebJarAssets.at(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/img""", """controllers.images.Images.showAdminImageForm(name:String ?= "")"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/img""", """controllers.images.Images.handleAdminImageForm"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """img/list""", """controllers.images.Images.jsonAllImageInfo"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """gallery""", """controllers.images.Images.showGallery"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """img/""" + "$" + """name<[^/]+>""", """controllers.images.Images.getImage(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """img/150x150/""" + "$" + """name<[^/]+>""", """controllers.images.Images.getThumbnail(name:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/albums""", """controllers.nuts.AdminCategories.adminAlbumsCategories"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/albums""", """controllers.nuts.AdminCategories.adminAlbumsCategoriesHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """index.php/article""", """controllers.nuts.Blog.showAllArticles"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """index.php/article/view/id/""" + "$" + """id<[^/]+>""", """controllers.nuts.Blog.article(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """blog/new""", """controllers.nuts.Blog.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """blog/""" + "$" + """id<[^/]+>/edit""", """controllers.nuts.Blog.edit(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """blog/submit""", """controllers.nuts.Blog.onSubmit"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/comments""", """controllers.nuts.Comments.commentsAdmin"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/comments/add""", """controllers.nuts.Comments.addComment"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/comments/editComment""", """controllers.nuts.Comments.editComment"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """comments/loginOrSignUp""", """controllers.nuts.Comments.loginOrSignUp"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """items""", """controllers.goods.Goods.listAllGoods"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """index.php/items/view/id/""" + "$" + """id<[^/]+>""", """controllers.goods.Goods.getGoodsItem(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/item""", """controllers.goods.Goods.showItemEditForm(id:Option[Long])"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/item""", """controllers.goods.Goods.itemEditFormHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/import-images""", """controllers.nuts.ImportData.importImages"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/import-articles""", """controllers.nuts.ImportData.importArticles"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/import-nuts""", """controllers.nuts.ImportData.importNuts"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/import-all""", """controllers.nuts.ImportData.importAll"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/cats""", """controllers.nuts.AdminCategories.adminGoodsCategories"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """admin/cats""", """controllers.nuts.AdminCategories.adminGoodsCategoriesHandle"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """name<.+>""", """controllers.Assets.at(path:String = "/public", name:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_pages_ApplicationController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_pages_ApplicationController_index0_invoker = createInvoker(
    ApplicationController_5.index,
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_pages_ApplicationController_signOut1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signOut")))
  )
  private[this] lazy val controllers_pages_ApplicationController_signOut1_invoker = createInvoker(
    ApplicationController_5.signOut,
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_SocialAuthController_authenticate2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("authenticate/"), DynamicPart("provider", """[^/]+""",true)))
  )
  private[this] lazy val controllers_auth_SocialAuthController_authenticate2_invoker = createInvoker(
    SocialAuthController_6.authenticate(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_SignUpController_view3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signUp")))
  )
  private[this] lazy val controllers_auth_SignUpController_view3_invoker = createInvoker(
    SignUpController_11.view,
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_SignUpController_submit4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signUp")))
  )
  private[this] lazy val controllers_auth_SignUpController_submit4_invoker = createInvoker(
    SignUpController_11.submit,
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_SignInController_view5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signIn")))
  )
  private[this] lazy val controllers_auth_SignInController_view5_invoker = createInvoker(
    SignInController_8.view,
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_SignInController_submit6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signIn")))
  )
  private[this] lazy val controllers_auth_SignInController_submit6_invoker = createInvoker(
    SignInController_8.submit,
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_ForgotPasswordController_view7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/forgot")))
  )
  private[this] lazy val controllers_auth_ForgotPasswordController_view7_invoker = createInvoker(
    ForgotPasswordController_0.view,
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_ForgotPasswordController_submit8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/forgot")))
  )
  private[this] lazy val controllers_auth_ForgotPasswordController_submit8_invoker = createInvoker(
    ForgotPasswordController_0.submit,
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_ResetPasswordController_view9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/reset/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_auth_ResetPasswordController_view9_invoker = createInvoker(
    ResetPasswordController_15.view(fakeValue[java.util.UUID]),
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_ResetPasswordController_submit10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/reset/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_auth_ResetPasswordController_submit10_invoker = createInvoker(
    ResetPasswordController_15.submit(fakeValue[java.util.UUID]),
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_ChangePasswordController_view11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/change")))
  )
  private[this] lazy val controllers_auth_ChangePasswordController_view11_invoker = createInvoker(
    ChangePasswordController_14.view,
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_ChangePasswordController_submit12_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("password/change")))
  )
  private[this] lazy val controllers_auth_ChangePasswordController_submit12_invoker = createInvoker(
    ChangePasswordController_14.submit,
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_ActivateAccountController_send13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/email/"), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val controllers_auth_ActivateAccountController_send13_invoker = createInvoker(
    ActivateAccountController_4.send(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
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
  private[this] lazy val controllers_auth_ActivateAccountController_activate14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("account/activate/"), DynamicPart("token", """[^/]+""",true)))
  )
  private[this] lazy val controllers_auth_ActivateAccountController_activate14_invoker = createInvoker(
    ActivateAccountController_4.activate(fakeValue[java.util.UUID]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.auth.ActivateAccountController",
      "activate",
      Seq(classOf[java.util.UUID]),
      "GET",
      """""",
      this.prefix + """account/activate/""" + "$" + """token<[^/]+>"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_WebJarAssets_at15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("webjars/"), DynamicPart("name", """.+""",false)))
  )
  private[this] lazy val controllers_WebJarAssets_at15_invoker = createInvoker(
    WebJarAssets_13.at(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebJarAssets",
      "at",
      Seq(classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path
GET         /assets/*name                    controllers.Assets.at(path="/public", name)""",
      this.prefix + """webjars/""" + "$" + """name<.+>"""
    )
  )

  // @LINE:33
  private[this] lazy val controllers_images_Images_showAdminImageForm16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/img")))
  )
  private[this] lazy val controllers_images_Images_showAdminImageForm16_invoker = createInvoker(
    Images_2.showAdminImageForm(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.images.Images",
      "showAdminImageForm",
      Seq(classOf[String]),
      "GET",
      """############################################
           Images in database              #
############################################""",
      this.prefix + """admin/img"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_images_Images_handleAdminImageForm17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/img")))
  )
  private[this] lazy val controllers_images_Images_handleAdminImageForm17_invoker = createInvoker(
    Images_2.handleAdminImageForm,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.images.Images",
      "handleAdminImageForm",
      Nil,
      "POST",
      """""",
      this.prefix + """admin/img"""
    )
  )

  // @LINE:35
  private[this] lazy val controllers_images_Images_jsonAllImageInfo18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("img/list")))
  )
  private[this] lazy val controllers_images_Images_jsonAllImageInfo18_invoker = createInvoker(
    Images_2.jsonAllImageInfo,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.images.Images",
      "jsonAllImageInfo",
      Nil,
      "GET",
      """""",
      this.prefix + """img/list"""
    )
  )

  // @LINE:36
  private[this] lazy val controllers_images_Images_showGallery19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("gallery")))
  )
  private[this] lazy val controllers_images_Images_showGallery19_invoker = createInvoker(
    Images_2.showGallery,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.images.Images",
      "showGallery",
      Nil,
      "GET",
      """""",
      this.prefix + """gallery"""
    )
  )

  // @LINE:37
  private[this] lazy val controllers_images_Images_getImage20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("img/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_images_Images_getImage20_invoker = createInvoker(
    Images_2.getImage(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.images.Images",
      "getImage",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """img/""" + "$" + """name<[^/]+>"""
    )
  )

  // @LINE:38
  private[this] lazy val controllers_images_Images_getThumbnail21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("img/150x150/"), DynamicPart("name", """[^/]+""",true)))
  )
  private[this] lazy val controllers_images_Images_getThumbnail21_invoker = createInvoker(
    Images_2.getThumbnail(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.images.Images",
      "getThumbnail",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """img/150x150/""" + "$" + """name<[^/]+>"""
    )
  )

  // @LINE:39
  private[this] lazy val controllers_nuts_AdminCategories_adminAlbumsCategories22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/albums")))
  )
  private[this] lazy val controllers_nuts_AdminCategories_adminAlbumsCategories22_invoker = createInvoker(
    AdminCategories_7.adminAlbumsCategories,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.AdminCategories",
      "adminAlbumsCategories",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/albums"""
    )
  )

  // @LINE:40
  private[this] lazy val controllers_nuts_AdminCategories_adminAlbumsCategoriesHandle23_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/albums")))
  )
  private[this] lazy val controllers_nuts_AdminCategories_adminAlbumsCategoriesHandle23_invoker = createInvoker(
    AdminCategories_7.adminAlbumsCategoriesHandle,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.AdminCategories",
      "adminAlbumsCategoriesHandle",
      Nil,
      "POST",
      """""",
      this.prefix + """admin/albums"""
    )
  )

  // @LINE:51
  private[this] lazy val controllers_nuts_Blog_showAllArticles24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index.php/article")))
  )
  private[this] lazy val controllers_nuts_Blog_showAllArticles24_invoker = createInvoker(
    Blog_10.showAllArticles,
    HandlerDef(this.getClass.getClassLoader,
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

  // @LINE:52
  private[this] lazy val controllers_nuts_Blog_article25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index.php/article/view/id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_nuts_Blog_article25_invoker = createInvoker(
    Blog_10.article(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Blog",
      "article",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """index.php/article/view/id/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:53
  private[this] lazy val controllers_nuts_Blog_create26_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("blog/new")))
  )
  private[this] lazy val controllers_nuts_Blog_create26_invoker = createInvoker(
    Blog_10.create,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Blog",
      "create",
      Nil,
      "GET",
      """""",
      this.prefix + """blog/new"""
    )
  )

  // @LINE:54
  private[this] lazy val controllers_nuts_Blog_edit27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("blog/"), DynamicPart("id", """[^/]+""",true), StaticPart("/edit")))
  )
  private[this] lazy val controllers_nuts_Blog_edit27_invoker = createInvoker(
    Blog_10.edit(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Blog",
      "edit",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """blog/""" + "$" + """id<[^/]+>/edit"""
    )
  )

  // @LINE:55
  private[this] lazy val controllers_nuts_Blog_onSubmit28_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("blog/submit")))
  )
  private[this] lazy val controllers_nuts_Blog_onSubmit28_invoker = createInvoker(
    Blog_10.onSubmit,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Blog",
      "onSubmit",
      Nil,
      "POST",
      """""",
      this.prefix + """blog/submit"""
    )
  )

  // @LINE:60
  private[this] lazy val controllers_nuts_Comments_commentsAdmin29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/comments")))
  )
  private[this] lazy val controllers_nuts_Comments_commentsAdmin29_invoker = createInvoker(
    Comments_1.commentsAdmin,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Comments",
      "commentsAdmin",
      Nil,
      "GET",
      """############################################
           Comments                        #
############################################""",
      this.prefix + """admin/comments"""
    )
  )

  // @LINE:61
  private[this] lazy val controllers_nuts_Comments_addComment30_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/comments/add")))
  )
  private[this] lazy val controllers_nuts_Comments_addComment30_invoker = createInvoker(
    Comments_1.addComment,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Comments",
      "addComment",
      Nil,
      "POST",
      """""",
      this.prefix + """admin/comments/add"""
    )
  )

  // @LINE:62
  private[this] lazy val controllers_nuts_Comments_editComment31_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/comments/editComment")))
  )
  private[this] lazy val controllers_nuts_Comments_editComment31_invoker = createInvoker(
    Comments_1.editComment,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Comments",
      "editComment",
      Nil,
      "POST",
      """""",
      this.prefix + """admin/comments/editComment"""
    )
  )

  // @LINE:63
  private[this] lazy val controllers_nuts_Comments_loginOrSignUp32_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("comments/loginOrSignUp")))
  )
  private[this] lazy val controllers_nuts_Comments_loginOrSignUp32_invoker = createInvoker(
    Comments_1.loginOrSignUp,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.Comments",
      "loginOrSignUp",
      Nil,
      "GET",
      """""",
      this.prefix + """comments/loginOrSignUp"""
    )
  )

  // @LINE:68
  private[this] lazy val controllers_goods_Goods_listAllGoods33_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("items")))
  )
  private[this] lazy val controllers_goods_Goods_listAllGoods33_invoker = createInvoker(
    Goods_9.listAllGoods,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.goods.Goods",
      "listAllGoods",
      Nil,
      "GET",
      """############################################
           Goods                           #
############################################""",
      this.prefix + """items"""
    )
  )

  // @LINE:69
  private[this] lazy val controllers_goods_Goods_getGoodsItem34_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("index.php/items/view/id/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_goods_Goods_getGoodsItem34_invoker = createInvoker(
    Goods_9.getGoodsItem(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.goods.Goods",
      "getGoodsItem",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """index.php/items/view/id/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:70
  private[this] lazy val controllers_goods_Goods_showItemEditForm35_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/item")))
  )
  private[this] lazy val controllers_goods_Goods_showItemEditForm35_invoker = createInvoker(
    Goods_9.showItemEditForm(fakeValue[Option[Long]]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.goods.Goods",
      "showItemEditForm",
      Seq(classOf[Option[Long]]),
      "GET",
      """""",
      this.prefix + """admin/item"""
    )
  )

  // @LINE:71
  private[this] lazy val controllers_goods_Goods_itemEditFormHandle36_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/item")))
  )
  private[this] lazy val controllers_goods_Goods_itemEditFormHandle36_invoker = createInvoker(
    Goods_9.itemEditFormHandle,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.goods.Goods",
      "itemEditFormHandle",
      Nil,
      "POST",
      """""",
      this.prefix + """admin/item"""
    )
  )

  // @LINE:73
  private[this] lazy val controllers_nuts_ImportData_importImages37_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/import-images")))
  )
  private[this] lazy val controllers_nuts_ImportData_importImages37_invoker = createInvoker(
    ImportData_3.importImages,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.ImportData",
      "importImages",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/import-images"""
    )
  )

  // @LINE:74
  private[this] lazy val controllers_nuts_ImportData_importArticles38_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/import-articles")))
  )
  private[this] lazy val controllers_nuts_ImportData_importArticles38_invoker = createInvoker(
    ImportData_3.importArticles,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.ImportData",
      "importArticles",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/import-articles"""
    )
  )

  // @LINE:75
  private[this] lazy val controllers_nuts_ImportData_importNuts39_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/import-nuts")))
  )
  private[this] lazy val controllers_nuts_ImportData_importNuts39_invoker = createInvoker(
    ImportData_3.importNuts,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.ImportData",
      "importNuts",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/import-nuts"""
    )
  )

  // @LINE:76
  private[this] lazy val controllers_nuts_ImportData_importAll40_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/import-all")))
  )
  private[this] lazy val controllers_nuts_ImportData_importAll40_invoker = createInvoker(
    ImportData_3.importAll,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.ImportData",
      "importAll",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/import-all"""
    )
  )

  // @LINE:78
  private[this] lazy val controllers_nuts_AdminCategories_adminGoodsCategories41_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/cats")))
  )
  private[this] lazy val controllers_nuts_AdminCategories_adminGoodsCategories41_invoker = createInvoker(
    AdminCategories_7.adminGoodsCategories,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.AdminCategories",
      "adminGoodsCategories",
      Nil,
      "GET",
      """""",
      this.prefix + """admin/cats"""
    )
  )

  // @LINE:79
  private[this] lazy val controllers_nuts_AdminCategories_adminGoodsCategoriesHandle42_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("admin/cats")))
  )
  private[this] lazy val controllers_nuts_AdminCategories_adminGoodsCategoriesHandle42_invoker = createInvoker(
    AdminCategories_7.adminGoodsCategoriesHandle,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.nuts.AdminCategories",
      "adminGoodsCategoriesHandle",
      Nil,
      "POST",
      """""",
      this.prefix + """admin/cats"""
    )
  )

  // @LINE:83
  private[this] lazy val controllers_Assets_at43_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("name", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at43_invoker = createInvoker(
    Assets_12.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """assets/""" + "$" + """name<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_pages_ApplicationController_index0_route(params) =>
      call { 
        controllers_pages_ApplicationController_index0_invoker.call(ApplicationController_5.index)
      }
  
    // @LINE:7
    case controllers_pages_ApplicationController_signOut1_route(params) =>
      call { 
        controllers_pages_ApplicationController_signOut1_invoker.call(ApplicationController_5.signOut)
      }
  
    // @LINE:8
    case controllers_auth_SocialAuthController_authenticate2_route(params) =>
      call(params.fromPath[String]("provider", None)) { (provider) =>
        controllers_auth_SocialAuthController_authenticate2_invoker.call(SocialAuthController_6.authenticate(provider))
      }
  
    // @LINE:10
    case controllers_auth_SignUpController_view3_route(params) =>
      call { 
        controllers_auth_SignUpController_view3_invoker.call(SignUpController_11.view)
      }
  
    // @LINE:11
    case controllers_auth_SignUpController_submit4_route(params) =>
      call { 
        controllers_auth_SignUpController_submit4_invoker.call(SignUpController_11.submit)
      }
  
    // @LINE:13
    case controllers_auth_SignInController_view5_route(params) =>
      call { 
        controllers_auth_SignInController_view5_invoker.call(SignInController_8.view)
      }
  
    // @LINE:14
    case controllers_auth_SignInController_submit6_route(params) =>
      call { 
        controllers_auth_SignInController_submit6_invoker.call(SignInController_8.submit)
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
        controllers_auth_ResetPasswordController_view9_invoker.call(ResetPasswordController_15.view(token))
      }
  
    // @LINE:19
    case controllers_auth_ResetPasswordController_submit10_route(params) =>
      call(params.fromPath[java.util.UUID]("token", None)) { (token) =>
        controllers_auth_ResetPasswordController_submit10_invoker.call(ResetPasswordController_15.submit(token))
      }
  
    // @LINE:20
    case controllers_auth_ChangePasswordController_view11_route(params) =>
      call { 
        controllers_auth_ChangePasswordController_view11_invoker.call(ChangePasswordController_14.view)
      }
  
    // @LINE:21
    case controllers_auth_ChangePasswordController_submit12_route(params) =>
      call { 
        controllers_auth_ChangePasswordController_submit12_invoker.call(ChangePasswordController_14.submit)
      }
  
    // @LINE:23
    case controllers_auth_ActivateAccountController_send13_route(params) =>
      call(params.fromPath[String]("email", None)) { (email) =>
        controllers_auth_ActivateAccountController_send13_invoker.call(ActivateAccountController_4.send(email))
      }
  
    // @LINE:24
    case controllers_auth_ActivateAccountController_activate14_route(params) =>
      call(params.fromPath[java.util.UUID]("token", None)) { (token) =>
        controllers_auth_ActivateAccountController_activate14_invoker.call(ActivateAccountController_4.activate(token))
      }
  
    // @LINE:28
    case controllers_WebJarAssets_at15_route(params) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_WebJarAssets_at15_invoker.call(WebJarAssets_13.at(name))
      }
  
    // @LINE:33
    case controllers_images_Images_showAdminImageForm16_route(params) =>
      call(params.fromQuery[String]("name", Some(""))) { (name) =>
        controllers_images_Images_showAdminImageForm16_invoker.call(Images_2.showAdminImageForm(name))
      }
  
    // @LINE:34
    case controllers_images_Images_handleAdminImageForm17_route(params) =>
      call { 
        controllers_images_Images_handleAdminImageForm17_invoker.call(Images_2.handleAdminImageForm)
      }
  
    // @LINE:35
    case controllers_images_Images_jsonAllImageInfo18_route(params) =>
      call { 
        controllers_images_Images_jsonAllImageInfo18_invoker.call(Images_2.jsonAllImageInfo)
      }
  
    // @LINE:36
    case controllers_images_Images_showGallery19_route(params) =>
      call { 
        controllers_images_Images_showGallery19_invoker.call(Images_2.showGallery)
      }
  
    // @LINE:37
    case controllers_images_Images_getImage20_route(params) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_images_Images_getImage20_invoker.call(Images_2.getImage(name))
      }
  
    // @LINE:38
    case controllers_images_Images_getThumbnail21_route(params) =>
      call(params.fromPath[String]("name", None)) { (name) =>
        controllers_images_Images_getThumbnail21_invoker.call(Images_2.getThumbnail(name))
      }
  
    // @LINE:39
    case controllers_nuts_AdminCategories_adminAlbumsCategories22_route(params) =>
      call { 
        controllers_nuts_AdminCategories_adminAlbumsCategories22_invoker.call(AdminCategories_7.adminAlbumsCategories)
      }
  
    // @LINE:40
    case controllers_nuts_AdminCategories_adminAlbumsCategoriesHandle23_route(params) =>
      call { 
        controllers_nuts_AdminCategories_adminAlbumsCategoriesHandle23_invoker.call(AdminCategories_7.adminAlbumsCategoriesHandle)
      }
  
    // @LINE:51
    case controllers_nuts_Blog_showAllArticles24_route(params) =>
      call { 
        controllers_nuts_Blog_showAllArticles24_invoker.call(Blog_10.showAllArticles)
      }
  
    // @LINE:52
    case controllers_nuts_Blog_article25_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_nuts_Blog_article25_invoker.call(Blog_10.article(id))
      }
  
    // @LINE:53
    case controllers_nuts_Blog_create26_route(params) =>
      call { 
        controllers_nuts_Blog_create26_invoker.call(Blog_10.create)
      }
  
    // @LINE:54
    case controllers_nuts_Blog_edit27_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_nuts_Blog_edit27_invoker.call(Blog_10.edit(id))
      }
  
    // @LINE:55
    case controllers_nuts_Blog_onSubmit28_route(params) =>
      call { 
        controllers_nuts_Blog_onSubmit28_invoker.call(Blog_10.onSubmit)
      }
  
    // @LINE:60
    case controllers_nuts_Comments_commentsAdmin29_route(params) =>
      call { 
        controllers_nuts_Comments_commentsAdmin29_invoker.call(Comments_1.commentsAdmin)
      }
  
    // @LINE:61
    case controllers_nuts_Comments_addComment30_route(params) =>
      call { 
        controllers_nuts_Comments_addComment30_invoker.call(Comments_1.addComment)
      }
  
    // @LINE:62
    case controllers_nuts_Comments_editComment31_route(params) =>
      call { 
        controllers_nuts_Comments_editComment31_invoker.call(Comments_1.editComment)
      }
  
    // @LINE:63
    case controllers_nuts_Comments_loginOrSignUp32_route(params) =>
      call { 
        controllers_nuts_Comments_loginOrSignUp32_invoker.call(Comments_1.loginOrSignUp)
      }
  
    // @LINE:68
    case controllers_goods_Goods_listAllGoods33_route(params) =>
      call { 
        controllers_goods_Goods_listAllGoods33_invoker.call(Goods_9.listAllGoods)
      }
  
    // @LINE:69
    case controllers_goods_Goods_getGoodsItem34_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_goods_Goods_getGoodsItem34_invoker.call(Goods_9.getGoodsItem(id))
      }
  
    // @LINE:70
    case controllers_goods_Goods_showItemEditForm35_route(params) =>
      call(params.fromQuery[Option[Long]]("id", None)) { (id) =>
        controllers_goods_Goods_showItemEditForm35_invoker.call(Goods_9.showItemEditForm(id))
      }
  
    // @LINE:71
    case controllers_goods_Goods_itemEditFormHandle36_route(params) =>
      call { 
        controllers_goods_Goods_itemEditFormHandle36_invoker.call(Goods_9.itemEditFormHandle)
      }
  
    // @LINE:73
    case controllers_nuts_ImportData_importImages37_route(params) =>
      call { 
        controllers_nuts_ImportData_importImages37_invoker.call(ImportData_3.importImages)
      }
  
    // @LINE:74
    case controllers_nuts_ImportData_importArticles38_route(params) =>
      call { 
        controllers_nuts_ImportData_importArticles38_invoker.call(ImportData_3.importArticles)
      }
  
    // @LINE:75
    case controllers_nuts_ImportData_importNuts39_route(params) =>
      call { 
        controllers_nuts_ImportData_importNuts39_invoker.call(ImportData_3.importNuts)
      }
  
    // @LINE:76
    case controllers_nuts_ImportData_importAll40_route(params) =>
      call { 
        controllers_nuts_ImportData_importAll40_invoker.call(ImportData_3.importAll)
      }
  
    // @LINE:78
    case controllers_nuts_AdminCategories_adminGoodsCategories41_route(params) =>
      call { 
        controllers_nuts_AdminCategories_adminGoodsCategories41_invoker.call(AdminCategories_7.adminGoodsCategories)
      }
  
    // @LINE:79
    case controllers_nuts_AdminCategories_adminGoodsCategoriesHandle42_route(params) =>
      call { 
        controllers_nuts_AdminCategories_adminGoodsCategoriesHandle42_invoker.call(AdminCategories_7.adminGoodsCategoriesHandle)
      }
  
    // @LINE:83
    case controllers_Assets_at43_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("name", None)) { (path, name) =>
        controllers_Assets_at43_invoker.call(Assets_12.at(path, name))
      }
  }
}
