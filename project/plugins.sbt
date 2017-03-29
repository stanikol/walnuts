// Comment to get more information during initialization
logLevel := Level.Warn

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.4")

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.3")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.14")

addSbtPlugin("com.heroku" % "sbt-heroku" % "1.0.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.7.6")
