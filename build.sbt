name := "FlightsInfo"

version := "1.0"

scalaVersion := "2.11.7"


libraryDependencies ++=
  Seq(
    "org.specs2" % "specs2-core_2.11" % "3.6.6",
    "org.specs2" % "specs2-junit_2.11" % "3.6.6",
    "org.specs2" % "specs2-mock_2.11" % "3.6.6",
    "org.specs2" % "specs2-mock_2.11" % "3.6.6",
    "io.spray" % "spray-json_2.11" % "1.3.1")

libraryDependencies += "junit" % "junit" % "4.12"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.0"
libraryDependencies += "org.hamcrest" % "hamcrest-junit" % "2.0.0.0"
libraryDependencies += "org.apache.commons" % "commons-csv" % "1.4"
libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.2.2"
