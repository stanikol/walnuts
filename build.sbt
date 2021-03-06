import com.heroku.sbt.HerokuPlugin.autoImport.herokuFatJar
import com.typesafe.sbt.SbtScalariform._

//import scalariform.formatter.preferences._

import org.scalajs.sbtplugin.ScalaJSPlugin

import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

name := "walnuts"

lazy val scalaV = "2.11.8"

version := "1.0.0"


lazy val sassCompile = taskKey[Unit]("Sass C compile")


lazy val serverDependencies = Seq(
  "com.mohiva" %% "play-silhouette" % "4.0.0",
  "com.mohiva" %% "play-silhouette-password-bcrypt" % "4.0.0",
  "com.mohiva" %% "play-silhouette-persistence" % "4.0.0",
  "com.mohiva" %% "play-silhouette-crypto-jca" % "4.0.0",
  "org.webjars" %% "webjars-play" % "2.5.0-2",
  "org.webjars" % "jquery-ui" % "1.11.4",
  "net.codingwell" %% "scala-guice" % "4.0.1",
  "com.iheart" %% "ficus" % "1.2.6",
  "com.typesafe.play" %% "play-mailer" % "5.0.0",
  "com.enragedginger" %% "akka-quartz-scheduler" % "1.5.0-akka-2.4.x",
  "com.adrianhurt" %% "play-bootstrap" % "1.0-P25-B3" exclude("org.webjars", "bootstrap"),
  "org.webjars" % "jquery" % "2.2.3",
  "org.webjars" % "bootstrap" % "3.3.7",
  //"com.mohiva" %% "play-silhouette-testkit" % "4.0.0" % "test",
  "org.postgresql" % "postgresql" % "9.4.1212",
  "com.typesafe.play" %% "play-slick" % "2.0.2",
  "com.typesafe.play" %% "play-slick-evolutions" % "2.0.2",
  "com.github.tototoshi" %% "slick-joda-mapper" % "2.2.0",
  "joda-time" % "joda-time" % "2.7",
  "org.joda" % "joda-convert" % "1.7",
//  specs2 % Test,
  cache,
  filters,
  "org.jsoup" % "jsoup" % "1.10.2", // https://mvnrepository.com/artifact/org.jsoup/jsoup
  //
  "com.sksamuel.scrimage" %% "scrimage-core" % "2.1.8"
  // "com.typesafe.play" %% "play-slick" % "2.0.0"
//  "com.sksamuel.scrimage" %% "scrimage-core" % "2.1.0"
//  "com.github.tminglei" %% "slick-pg" % "0.15.0-M4"
//  "com.github.tminglei" %% "slick-pg" % "0.12.1"
)


lazy val server = (project in file("server"))
    .settings(
      name := "walnuts",
      scalaVersion := scalaV,
      resolvers += "Atlassian Releases" at "https://maven.atlassian.com/public/",
      resolvers += Resolver.jcenterRepo,
      libraryDependencies ++= serverDependencies,
      routesGenerator := InjectedRoutesGenerator,
      routesImport += "utils.route.Binders._",
//      scalaJSProjects := Seq(client),
//      pipelineStages in Assets := Seq(scalaJSPipeline),
      //pipelineStages := Seq(digest, gzip),
      // triggers scalaJSPipeline when using compile or continuous compilation
      TwirlKeys.templateImports ++= Seq(
        "models.blog._",
        "models.goods._",
        "models.images._",
        "controllers.blog.FormsData._",
        "controllers.goods.FormsData._",
        "controllers.images.FormsData._"
      ),
      scalaVersion in ThisBuild := scalaV,
      scalacOptions ++= Seq(
        "-deprecation", // Emit warning and location for usages of deprecated APIs.
        "-feature", // Emit warning and location for usages of features that should be imported explicitly.
        "-unchecked", // Enable additional warnings where generated code depends on assumptions.
        "-Xfatal-warnings", // Fail the compilation if there are any warnings.
        "-Xlint", // Enable recommended additional warnings.
        "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver.
        "-Ywarn-dead-code", // Warn when dead code is identified.
        "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures.
        "-Ywarn-nullary-override", // Warn when non-nullary overrides nullary, e.g. def foo() over def foo.
        "-Ywarn-numeric-widen" // Warn when numerics are widened.
      ),
      //compile in Compile := ((compile in Compile) dependsOn scalaJSPipeline).value,
      // mainClass in assembly := Some("play.core.server.ProdServerStart$.main"),
      fullClasspath in assembly += Attributed.blank(PlayKeys.playPackageAssets.value),
      assemblyMergeStrategy in assembly :=  {
        case PathList(ps @ _*) if ps.last endsWith "class" => MergeStrategy.first
        case PathList(ps @ _*) if ps.last == "io.netty.versions.properties" => MergeStrategy.concat
        //case PathList(ps @ _*) if ps.last == "play-silhouette_2.11-4.0.0.jar" => MergeStrategy.first
        case "messages" => MergeStrategy.concat
        case "application.conf" => MergeStrategy.concat
        case "unwanted.txt"     => MergeStrategy.discard
        case x =>
          val oldStrategy = (assemblyMergeStrategy in assembly).value
          oldStrategy(x)
      },
      herokuAppName in Compile := "walnuts",
      herokuFatJar in Compile := Some((assemblyOutputPath in assembly).value)
    )
    .enablePlugins(PlayScala)
//    .dependsOn(sharedJvm)


//********************************************************
// Scalariform settings
//********************************************************

// defaultScalariformSettings
//
// ScalariformKeys.preferences := ScalariformKeys.preferences.value
//   .setPreference(FormatXml, false)
//   .setPreference(DoubleIndentClassDeclaration, false)
//   .setPreference(DanglingCloseParenthesis, Preserve)


//lazy val client = (project in file("client")).settings(
//  scalaVersion := scalaV,
//  persistLauncher := true,
//  persistLauncher in Test := false,
////  mainClass := Some("example.ScalaJSExample"),
//  libraryDependencies ++= Seq(
//    "org.scala-js" %%% "scalajs-dom" % "0.9.1"
//  )
//).enablePlugins(ScalaJSPlugin, ScalaJSWeb).
//  dependsOn(sharedJs)
//
//lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared")).
//  settings(scalaVersion := scalaV).
//  jsConfigure(_ enablePlugins ScalaJSWeb)
//
//lazy val sharedJvm = shared.jvm
//lazy val sharedJs = shared.js

// loads the server project at sbt startup
onLoad in Global := (Command.process("project server", _: State)) compose (onLoad in Global).value

watchSources += baseDirectory.value / "sass" / "main.scss"

watchSources += baseDirectory.value / "sass" / "admin.scss"

sassCompile in Global := {
  println("Compiling SASS: ...")
  val root = baseDirectory.in(server).value.getAbsolutePath
  val main = "sassc server/sass/main.scss server/public/styles/main.css".!
  val admin = "sassc server/sass/admin.scss server/public/styles/admin.css".!
  println(s"Compiling SASS: \n$main \n$admin")
}
