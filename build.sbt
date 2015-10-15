lazy val root = (project in file(".")).
  settings(
    name := "lunchup",
    libraryDependencies ++= Seq(
      "org.apache.commons" % "commons-io" % "1.3.2",
      "org.apache.commons" % "commons-jexl" % "2.1.1",
      "org.apache.commons" % "commons-lang3" % "3.0",
      "com.googlecode.concurrentlinkedhashmap" % "concurrentlinkedhashmap-lru" % "1.4.2",
      "org.json4s" %% "json4s-native" % "3.3.0"
	)
  )
