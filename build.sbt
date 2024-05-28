// Project info
name := "VecMatLib"
homepage := Some(url("https://github.com/ScalaMath/VecMatLib"))
version := "3.1"
description := "A Scala library for vectors and matrix math"
// Organization info
organization := "io.github.scalamath"
organizationName := "ScalaMath"
organizationHomepage := Some(url("https://github.com/ScalaMath"))
// Project scala version
scalaVersion := "2.13.12"

// Do not append the scala version to the generated artifact
crossPaths := false

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

// Publish to local repository
pomIncludeRepository := { _ => false }
publishTo := Some(Resolver.file("local-ivy", file(Path.userHome + "/.ivy2")))
publishMavenStyle := true