import sbt._

object Dependencies {
  private val scalaTestVersion = "3.2.18.0"

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.2.19" % Test
  lazy val scalaCheck =
    "org.scalatestplus" %% "scalacheck-1-17" % scalaTestVersion % Test
  lazy val mockito = "org.scalatestplus" %% "mockito-4-11" % "3.2.18.0" % Test
  lazy val catsCore = "org.typelevel" %% "cats-core" % "2.12.0"
  lazy val approvalsTests =
    "com.approvaltests" % "approvaltests" % "24.3.0" % Test
  lazy val scalaTestJunit =
    "org.scalatestplus" %% "junit-5-10" % scalaTestVersion % Test
}
