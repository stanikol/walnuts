
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Mon Mar 20 14:43:04 EET 2017

package controllers.nuts;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.nuts.ReverseComments Comments = new controllers.nuts.ReverseComments(RoutesPrefix.byNamePrefix());
  public static final controllers.nuts.ReverseImages Images = new controllers.nuts.ReverseImages(RoutesPrefix.byNamePrefix());
  public static final controllers.nuts.ReverseBlog Blog = new controllers.nuts.ReverseBlog(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.nuts.javascript.ReverseComments Comments = new controllers.nuts.javascript.ReverseComments(RoutesPrefix.byNamePrefix());
    public static final controllers.nuts.javascript.ReverseImages Images = new controllers.nuts.javascript.ReverseImages(RoutesPrefix.byNamePrefix());
    public static final controllers.nuts.javascript.ReverseBlog Blog = new controllers.nuts.javascript.ReverseBlog(RoutesPrefix.byNamePrefix());
  }

}
