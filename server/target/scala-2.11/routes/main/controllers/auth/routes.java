
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Wed Mar 29 17:21:32 EEST 2017

package controllers.auth;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.auth.ReverseSignInController SignInController = new controllers.auth.ReverseSignInController(RoutesPrefix.byNamePrefix());
  public static final controllers.auth.ReverseSocialAuthController SocialAuthController = new controllers.auth.ReverseSocialAuthController(RoutesPrefix.byNamePrefix());
  public static final controllers.auth.ReverseResetPasswordController ResetPasswordController = new controllers.auth.ReverseResetPasswordController(RoutesPrefix.byNamePrefix());
  public static final controllers.auth.ReverseActivateAccountController ActivateAccountController = new controllers.auth.ReverseActivateAccountController(RoutesPrefix.byNamePrefix());
  public static final controllers.auth.ReverseForgotPasswordController ForgotPasswordController = new controllers.auth.ReverseForgotPasswordController(RoutesPrefix.byNamePrefix());
  public static final controllers.auth.ReverseChangePasswordController ChangePasswordController = new controllers.auth.ReverseChangePasswordController(RoutesPrefix.byNamePrefix());
  public static final controllers.auth.ReverseSignUpController SignUpController = new controllers.auth.ReverseSignUpController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.auth.javascript.ReverseSignInController SignInController = new controllers.auth.javascript.ReverseSignInController(RoutesPrefix.byNamePrefix());
    public static final controllers.auth.javascript.ReverseSocialAuthController SocialAuthController = new controllers.auth.javascript.ReverseSocialAuthController(RoutesPrefix.byNamePrefix());
    public static final controllers.auth.javascript.ReverseResetPasswordController ResetPasswordController = new controllers.auth.javascript.ReverseResetPasswordController(RoutesPrefix.byNamePrefix());
    public static final controllers.auth.javascript.ReverseActivateAccountController ActivateAccountController = new controllers.auth.javascript.ReverseActivateAccountController(RoutesPrefix.byNamePrefix());
    public static final controllers.auth.javascript.ReverseForgotPasswordController ForgotPasswordController = new controllers.auth.javascript.ReverseForgotPasswordController(RoutesPrefix.byNamePrefix());
    public static final controllers.auth.javascript.ReverseChangePasswordController ChangePasswordController = new controllers.auth.javascript.ReverseChangePasswordController(RoutesPrefix.byNamePrefix());
    public static final controllers.auth.javascript.ReverseSignUpController SignUpController = new controllers.auth.javascript.ReverseSignUpController(RoutesPrefix.byNamePrefix());
  }

}
