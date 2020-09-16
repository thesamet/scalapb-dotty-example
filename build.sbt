val dottyVersion = "0.27.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-simple",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",

    libraryDependencies -= "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion,

    libraryDependencies += ("com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion).withDottyCompat(scalaVersion.value),

    PB.targets in Compile := Seq(
      scalapb.gen() -> (sourceManaged in Compile).value / "scalapb"
    )
  )
