name := "SBT-Assignment"

version := "0.1"

scalaVersion := "2.12.12"

idePackagePrefix := Some("sbt")

lazy val persistence = project.in(file("persistence"))
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick" % "3.3.3",
      "mysql" % "mysql-connector-java" % "8.0.25",
      "org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.mockito" %% "mockito-scala" % "1.16.37" % Test,
      "com.h2database" % "h2" % "1.4.200" % Test
    )
  )

lazy val http = project.in(file("http"))
  .settings(
    libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-http" % "10.2.5",
      "com.typesafe.akka" %% "akka-stream" % "2.6.15",
      "com.typesafe.akka" %% "akka-actor" % "2.6.15",
      "com.typesafe.akka" %% "akka-stream-testkit" % "2.6.15" % Test,
      "com.typesafe.akka" %% "akka-http-testkit" % "10.2.5" % Test,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % "2.6.15" % Test
    )
  )

lazy val root = project.in(file(".")).aggregate(persistence, http)