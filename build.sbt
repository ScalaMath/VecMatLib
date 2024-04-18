// Project info
name := "VecMatLib"
homepage := Some(url("https://github.com/ScalaMath/VecMatLib"))
organization := "io.github.scalamath"
organizationName := "ScalaMath"
organizationHomepage := Some(url("https://github.com/ScalaMath"))
version := "3.0"
description := "A Scala library for vectors and matrix math"
// Project scala version
scalaVersion := "2.13.12"

// Scala test dependency
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.18" % Test
// Junit test dependency
libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % Test

// Show deprecation warnings
scalacOptions ++= Seq("-unchecked", "-deprecation")

// Publish info
scmInfo := Some(
  ScmInfo(
    url("https://github.com/ScalaMath/VecMatLib"),
    "scm:git@github.com:ScalaMath/VecMatLib.git"
  )
)

// Developer info
developers := List(
  Developer(
    id = "HexagonNico",
    name = "Nicholas Amigoni",
    email = "nico.hex6@gmail.com",
    url = url("https://hexagonnico.github.io")
  )
)

// Project license
licenses := List(
  "Apache 2" -> new URL("https://www.apache.org/licenses/LICENSE-2.0.txt")
)

// Maven publishing
pomIncludeRepository := { _ => false }
publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
publishMavenStyle := true