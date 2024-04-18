// Project info
name := "VecMatLib"
organization := "io.github.scalamath"
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