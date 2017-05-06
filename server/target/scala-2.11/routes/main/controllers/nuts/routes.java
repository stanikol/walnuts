
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Sun May 07 01:48:52 EEST 2017

package controllers.nuts;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.nuts.ReverseComments Comments = new controllers.nuts.ReverseComments(RoutesPrefix.byNamePrefix());
  public static final controllers.nuts.ReverseAdminCategories AdminCategories = new controllers.nuts.ReverseAdminCategories(RoutesPrefix.byNamePrefix());
  public static final controllers.nuts.ReverseBlog Blog = new controllers.nuts.ReverseBlog(RoutesPrefix.byNamePrefix());
  public static final controllers.nuts.ReverseImportData ImportData = new controllers.nuts.ReverseImportData(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.nuts.javascript.ReverseComments Comments = new controllers.nuts.javascript.ReverseComments(RoutesPrefix.byNamePrefix());
    public static final controllers.nuts.javascript.ReverseAdminCategories AdminCategories = new controllers.nuts.javascript.ReverseAdminCategories(RoutesPrefix.byNamePrefix());
    public static final controllers.nuts.javascript.ReverseBlog Blog = new controllers.nuts.javascript.ReverseBlog(RoutesPrefix.byNamePrefix());
    public static final controllers.nuts.javascript.ReverseImportData ImportData = new controllers.nuts.javascript.ReverseImportData(RoutesPrefix.byNamePrefix());
  }

}
