
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Wed Mar 29 17:21:32 EEST 2017

package controllers.pages;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.pages.ReverseApplicationController ApplicationController = new controllers.pages.ReverseApplicationController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.pages.javascript.ReverseApplicationController ApplicationController = new controllers.pages.javascript.ReverseApplicationController(RoutesPrefix.byNamePrefix());
  }

}
