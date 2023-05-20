ThisBuild / organization := "org.inverseplayers"
ThisBuild / version := "0.0.1-SNAPSHOT"
ThisBuild / scalaVersion := V.Scala
ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.6.0"
// resolvers in ThisBuild += "Maven Central" at "https://repo1.maven.org/maven2/"

val V = new {
  val tyrian = "0.6.2"
  val Scala = "3.2.2"
  val circe = "0.15.0-M1"
}

val Dependencies = new {
  lazy val devscanFrontend = Seq(
    libraryDependencies ++= Seq(
      "io.indigoengine" %%% "tyrian-io" % V.tyrian,
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.13.0",
      "io.circe" %%% "circe-core" % V.circe,
      "io.circe" %%% "circe-generic" % V.circe,
      "io.circe" %%% "circe-parser" % V.circe
      // "org.jsoup" %%% "jsoup" % "1.14.3"
      // "com.github.mcallisto" %%% "scalajs-jsoup" % "1.14.3"
    )
  )
  lazy val parsetoCommon = Seq(
    libraryDependencies ++= Seq(
      "io.circe" %%% "circe-core" % V.circe,
      "io.circe" %%% "circe-generic" % V.circe,
      "io.circe" %%% "circe-parser" % V.circe
    )
  )
}

lazy val root = (project in file("."))
  .aggregate(
    devscanFrontend,
    devscanCats,
    testModule,
    parsetoCommon,
    parsetoFrontEnd
  )

lazy val devscanCats = (project in file("modules/devscan-cats"))
  .settings(
    name := "devscan-cats",
    fork in run := true,
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      // cats
      "org.typelevel" %% "cats-effect" % "3.4.9",
      "org.typelevel" %% "cats-core" % "2.7.0",
      "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test,

      // process csv
      "au.com.bytecode" % "opencsv" % "2.4",

      // get json data from test api
      "com.lihaoyi" %% "requests" % "0.8.0",

      // write module
      "com.lihaoyi" %% "os-lib" % "0.9.1",

      // parser
      "io.circe" %% "circe-generic" % V.circe,
      "io.circe" %% "circe-parser" % V.circe,
      "io.circe" %% "circe-refined" % V.circe
    )
    // resolvers += "Maven Central" at "https://repo1.maven.org/maven2/"
  )

lazy val devscanFrontend = (project in file("modules/devscan-frontend"))
  .enablePlugins(ScalaJSPlugin)
  .settings(Dependencies.devscanFrontend)
  .settings(
    name := "devscan-frontend",
    version := "0.0.1",
    organization := "inverseplayers",
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  )
  .dependsOn(parsetoCommon)

lazy val parsetoFrontEnd = (project in file("modules/parseto-frontend"))
  .enablePlugins(ScalaJSPlugin)
  .settings(Dependencies.devscanFrontend)
  .settings(
    name := "parseto-frontend",
    version := "0.0.1",
    organization := "inverseplayers",
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }
  )
  .dependsOn(parsetoCommon)

lazy val parsetoCommon = (project in file("modules/parseto-common"))
  .enablePlugins(ScalaJSPlugin)
  .settings(Dependencies.parsetoCommon)
  .settings(
    name := "parseto-common",
    version := "0.0.1",
    organization := "inverseplayers"
  )

lazy val testModule = (project in file("modules/test-module"))
  .settings(
    name := "text-module",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      // cats
      "org.typelevel" %% "cats-effect" % "3.3.1",
      "org.typelevel" %% "cats-core" % "2.7.0",
      "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test,

      // process csv
      "au.com.bytecode" % "opencsv" % "2.4",

      // get json data from test api
      "com.lihaoyi" %% "requests" % "0.8.0",

      // write module
      "com.lihaoyi" %% "os-lib" % "0.9.1",

      // parser
      "io.circe" %% "circe-generic" % V.circe,
      "io.circe" %% "circe-parser" % V.circe,
      "io.circe" %% "circe-refined" % V.circe
    )
  )
