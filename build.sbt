ThisBuild / organization := "org.leisuremeta"
ThisBuild / version := "0.0.1-SNAPSHOT"
ThisBuild / scalaVersion := V.Scala
ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.6.0"

val V = new {
  val tyrian = "0.6.2"
  val Scala = "3.2.2"
}

val Dependencies = new {
  lazy val devscanFrontend = Seq(
    libraryDependencies ++= Seq(
      "io.indigoengine" %%% "tyrian-io" % V.tyrian
    )
  )
}

lazy val root = (project in file("."))
  .aggregate(
    devscanFrontend
  )

lazy val devscanFrontend = (project in file("modules/devscan-frontend"))
  .enablePlugins(ScalaJSPlugin)
  .settings(Dependencies.devscanFrontend)
  .settings(
    name := "devscan-frontend",
    version := "0.0.1",
    organization := "inverseplayers",
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) }

    // 불필요한세팅
    //   scalafixOnCompile := true,
    //   semanticdbEnabled := true,
    //   semanticdbVersion := scalafixSemanticdb.revision,
    //   autoAPIMappings := true
  )
