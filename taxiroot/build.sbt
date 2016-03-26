name := "taxiroot"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.6.1",
  "org.apache.spark" %% "spark-mllib" % "1.6.1",
  "org.apache.spark" %% "spark-sql" % "1.6.1",
  "org.apache.hadoop" % "hadoop-client" % "2.7.2",
  "com.github.nscala-time" %% "nscala-time" % "2.10.0",
  "com.esri.geometry" % "esri-geometry-api" % "1.2.1",
  "io.spray" % "spray-json_2.11" % "1.3.2",
  "joda-time" % "joda-time" % "2.9.2"
)
