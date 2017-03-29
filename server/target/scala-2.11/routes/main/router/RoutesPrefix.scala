
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/snc/scala/walnuts/server/conf/routes
// @DATE:Thu Mar 30 01:46:36 EEST 2017

package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
