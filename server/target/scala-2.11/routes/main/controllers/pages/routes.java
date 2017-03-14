
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Wed Mar 15 00:23:29 EET 2017

package controllers.pages;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.pages.ReverseApplicationController ApplicationController = new controllers.pages.ReverseApplicationController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.pages.javascript.ReverseApplicationController ApplicationController = new controllers.pages.javascript.ReverseApplicationController(RoutesPrefix.byNamePrefix());
  }

}
