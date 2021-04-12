val zioVersion = "1.0.6"

lazy val root = project
  .in(file("."))
  .settings(
    name := "$name$",
    inThisBuild(
      List(
        organization := "$organization$",
        version := "0.0.1",
        scalaVersion := "$dotty_version$"
      )
    ),
    addCompilerPlugin(("com.olegpy" %% "better-monadic-for" % "0.3.1").cross(CrossVersion.for3Use2_13)),
    libraryDependencies ++= Seq(
      ("dev.zio" %% "zio"               % zioVersion).cross(CrossVersion.for3Use2_13),
      ("dev.zio" %% "zio-test"          % zioVersion % Test).cross(CrossVersion.for3Use2_13),
      ("dev.zio" %% "zio-test-sbt"      % zioVersion % Test).cross(CrossVersion.for3Use2_13),
      ("dev.zio" %% "zio-test-junit"    % zioVersion % Test).cross(CrossVersion.for3Use2_13),
      ("dev.zio" %% "zio-test-magnolia" % zioVersion % Test).cross(CrossVersion.for3Use2_13)
    ),
    libraryDependencies := libraryDependencies.value.map(_.withDottyCompat(scalaVersion.value)),
    testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))
  )
