lazy val root = (project in file(".")).
  settings(
    name := "lunchup",
    libraryDependencies ++= Seq(
      "org.apache.commons" % "commons-io" % "1.3.2",
      "org.apache.commons" % "commons-lang3" % "3.0"
	)
  )
