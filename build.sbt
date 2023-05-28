ThisBuild / version := "2.0"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file(".")).settings(
  name := "VecMatLib"
)

// Scala test dependency
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test

// Junit test dependency
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.13.2" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test
)

// Publishing
ThisBuild / organization := "io.github.hexagonnico"
ThisBuild / organizationName := "vecmatlib"
ThisBuild / organizationHomepage := Some(url("https://github.com/HexagonNico/VecMatLib"))
ThisBuild / crossPaths := false

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/HexagonNico/VecMatLib"),
    "git@github.com:HexagonNico/VecMatLib.git"
  )
)

ThisBuild / developers := List(
  Developer(
    id = "HexagonNico",
    name = "Nicholas Amigoni",
    email = "nico.hex6@gmail.com",
    url = url("https://hexagonnico.github.io")
  )
)

ThisBuild / description := "A Scala library for vectors and matrix math"
ThisBuild / licenses := List(
  "Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt")
)
ThisBuild / homepage := Some(url("https://github.com/HexagonNico/VecMatLib"))

ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://s01.oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
