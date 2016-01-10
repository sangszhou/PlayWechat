import sbt._

name := """PlaySeed"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).dependsOn(weixin)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "org.scala-lang.modules" %% "scala-xml" % "1.0.4",
  "com.foxinmy" % "weixin4j-mp" % "1.5.3",
  "org.scalatest" % "scalatest_2.11" % "3.0.0-M14"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

val basicSettings = Seq(
  version := "0.0.2",
  homepage := Some(new URL("http://github.com/yangbajing/wechat-meal")),
  organization := "me.xinszhou",
  organizationHomepage := Some(new URL("https://github.com/yangbajing/wechat-meal")),
  startYear := Some(2015),
  scalaVersion := "2.11.7",
  scalacOptions ++= Seq(
    "-encoding", "utf8",
    "-unchecked",
    "-feature",
    "-deprecation"
  ),
  javacOptions ++= Seq(
    "-encoding", "utf8",
    "-Xlint:unchecked",
    "-Xlint:deprecation"
  ),
  publish :=(),
  publishLocal :=(),
  publishTo := None,
  offline := true,
  resolvers ++= Seq(
    "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    "Sonatype releases" at "http://oss.sonatype.org/content/repositories/releases",
    "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
    "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots")
)

lazy val weixin = Project("WechatPlatform", file("WechatPlatform"))
  .settings(basicSettings)
  .settings(
    description := "wechat",
    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-xml" % "1.0.4",
      "org.scalatest" % "scalatest_2.11" % "3.0.0-M14"
    ))


