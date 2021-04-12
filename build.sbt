val zioVersion = "1.0.6"

lazy val root = project
  .in(file("."))
  .settings(
    name := "zio-dotty-quickstart",
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
    },
    addCompilerPlugin(("com.olegpy" %% "better-monadic-for" % "0.3.1").cross(CrossVersion.for3Use2_13)),
    libraryDependencies ++= Seq(
      ("dev.zio" %% "zio"               % zioVersion).cross(CrossVersion.for3Use2_13),
      ("dev.zio" %% "zio-test"          % zioVersion % Test).cross(CrossVersion.for3Use2_13),
      ("dev.zio" %% "zio-test-sbt"      % zioVersion % Test).cross(CrossVersion.for3Use2_13),
      ("dev.zio" %% "zio-test-junit"    % zioVersion % Test).cross(CrossVersion.for3Use2_13),
      ("dev.zio" %% "zio-test-magnolia" % zioVersion % Test).cross(CrossVersion.for3Use2_13)
    ),
    scriptedLaunchOpts ++= List("-Xms1024m", "-Xmx1024m", "-XX:ReservedCodeCacheSize=128m", "-XX:MaxPermSize=256m", "-Xss2m", "-Dfile.encoding=UTF-8"),
    resolvers += Resolver.url("typesafe", url("https://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns)
  )
