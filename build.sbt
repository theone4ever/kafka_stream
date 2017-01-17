import sbt._

name := "kafka-stream"

scalaVersion := "2.11.7"

val sparkVersion = "2.0.2"

lazy val root = (project in file("."))
  .settings(SparkSubmit.settings: _*)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-streaming" % sparkVersion % "provided",
  ("org.apache.spark" %% "spark-streaming-kafka-0-8" % "2.0.2") exclude ("org.spark-project.spark", "unused")
)

/**
  * Specify main class, so we don't need to use "--class" when do spark submit
  */
mainClass in Compile := Some("DirectKafkaWordCount")

/**
  * Use fat jar to include all dependencies like spark-streaming-kafka.
  */
sparkSubmitJar := assembly.value.getAbsolutePath

