import Dependencies.*
import org.typelevel.scalacoptions.ScalacOptions
import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion := "2.13.14"
ThisBuild / organization := "nl.codecraftr"
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision
ThisBuild / scalafixScalaBinaryVersion := "2.13"
ThisBuild / javacOptions ++= Seq("-source", "21", "-target", "21")
tpolecatScalacOptions += ScalacOptions.release("21")

lazy val root = project
    .enablePlugins(ScalafmtPlugin)
    .in(file("."))
    .settings(
        name := "graph-kata-scala",
        version := "0.1.0-SNAPSHOT",
        libraryDependencies ++= Seq(
            scalaTest,
            scalaTestJunit,
            scalaCheck,
            approvalsTests,
            mockito,
            catsCore,
        ),
        libraryDependencies += "org.scala-graph" %% "graph-core" % "2.0.1",
        libraryDependencies += "org.scala-graph" %% "graph-dot" % "2.0.0"
    )
