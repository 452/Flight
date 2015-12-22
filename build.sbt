name := "PostalCodeInventory"

version := "1.0"

scalaVersion := "2.11.7"


libraryDependencies ++=
  Seq(
    "org.specs2" % "specs2-core_2.11" % "3.6.6",
    "org.specs2" % "specs2-junit_2.11" % "3.6.6",
    "org.specs2" % "specs2-mock_2.11" % "3.6.6",
    "com.github.tototoshi" % "scala-csv_2.11" % "1.2.2",
    "io.spray" % "spray-json_2.11" % "1.3.1")
    