import sbtsparksubmit.SparkSubmitPlugin.autoImport._

object SparkSubmit {
  lazy val settings =
    SparkSubmitSetting("spark",
      Seq("--master", "spark://localhost:7077"),
      Seq("127.0.0.1:9092", "word-count")
    )
}