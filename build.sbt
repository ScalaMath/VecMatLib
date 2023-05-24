ThisBuild / version := "1.2.2"

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
