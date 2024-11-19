ThisBuild / licenses += "ISC" -> url("https://opensource.org/licenses/ISC")
ThisBuild / versionScheme     := Some("semver-spec")

publish / skip := true

lazy val oql_rdb = crossProject(JSPlatform, JVMPlatform, NativePlatform)
  .in(file("."))
  .settings(
    name         := "oql-rdb",
    version      := "0.0.1",
    scalaVersion := "3.5.2",
    scalacOptions ++=
      Seq(
        "-deprecation",
        "-feature",
        "-unchecked",
        "-language:postfixOps",
        "-language:implicitConversions",
        "-language:existentials",
        "-language:dynamics",
      ),
    organization := "com.vinctus",
    githubOwner  := "edadma", // this is temporary until the transfer of ownership
    resolvers += "GitHub Packages" at "https://maven.pkg.github.com/vinctustech/sjs-utils",
    githubRepository                        := name.value,
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.2.19" % "test",
    libraryDependencies ++= Seq(
      "com.vinctus"      %%% "oql-core" % "0.0.3",
      "io.github.edadma" %%% "dal"      % "0.1.10",
      "io.github.edadma" %%% "rdb"      % "0.0.1",
//      "com.github.scopt" %%% "scopt" % "4.1.0",
//      "com.lihaoyi" %%% "pprint" % "0.9.0" % "test",
    ),
    publishMavenStyle      := true,
    Test / publishArtifact := false,
    licenses += "ISC"      -> url("https://opensource.org/licenses/ISC"),
  )
  .jvmSettings(
    libraryDependencies += "org.scala-js" %% "scalajs-stubs" % "1.1.0" % "provided",
  )
  .nativeSettings(
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-time" % "2.6.0",
  )
  .jsSettings(
    jsEnv := new org.scalajs.jsenv.nodejs.NodeJSEnv(),
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
      //    Test / scalaJSUseMainModuleInitializer := true,
    //    Test / scalaJSUseTestModuleInitializer := false,
    Test / scalaJSUseMainModuleInitializer      := false,
    Test / scalaJSUseTestModuleInitializer      := true,
    scalaJSUseMainModuleInitializer             := true,
    libraryDependencies += "io.github.cquiroz" %%% "scala-java-time" % "2.6.0",
  )
