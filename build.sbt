organization in ThisBuild := "de.surfice"

version in ThisBuild := "0.0.1-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.12"

val Version = new {
  val swog        = "0.1.0-SNAPSHOT"
  val smacrotools = "0.0.8"
  val utest       = "0.6.8-SNAPSHOT"
}


lazy val commonSettings = Seq(
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-language:implicitConversions","-Xlint"),
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
  libraryDependencies ++= Seq(
    "de.surfice" %%% "swog-cxx" % Version.swog
    ),
  resolvers += Opts.resolver.sonatypeSnapshots
)

lazy val qt5 = project.in(file("."))
  .enablePlugins(ScalaNativePlugin)
  .aggregate(macros,core,gui,widgets)
  .settings(commonSettings ++ dontPublish:_*)
  .settings(
    name := "scalanative-qt5",
    description := "ScalaNative bindings for Qt5"
  )

lazy val macros = project
  .enablePlugins(ScalaNativePlugin)
  .settings(commonSettings ++ publishingSettings: _*)
  .settings(
    name := "scalanative-qt5-macros"
  )

lazy val core = project
  .enablePlugins(ScalaNativePlugin)
  .dependsOn(macros)
  .settings(commonSettings ++ publishingSettings: _*)
  .settings(
    name := "scalanative-qt5-core"
  )

lazy val gui = project
  .enablePlugins(ScalaNativePlugin)
  .dependsOn(core)
  .settings(commonSettings ++ publishingSettings: _*)
  .settings(
    name := "scalanative-qt5-gui"
  )

lazy val widgets = project
  .enablePlugins(ScalaNativePlugin)
  .dependsOn(gui)
  .settings(commonSettings ++ publishingSettings: _*)
  .settings(
    name := "scalanative-qt5-widgets"
  )

lazy val demo = project
  .enablePlugins(ScalaNativePlugin,NBHAutoPlugin,NBHCxxPlugin,NBHPkgConfigPlugin)
  .dependsOn(widgets)
  .settings(commonSettings ++ dontPublish: _*)
  .settings(
    nativeLinkStubs := true,
    nbhPkgConfigModules ++= Seq("Qt5Widgets"),
    nbhCxxCXXFlags := "-std=c++11 -g" +: nbhPkgConfigCFlags.value,
    nbhCxxLDFlags := nbhPkgConfigLinkingFlags.value
  )

lazy val dontPublish = Seq(
  publish := {},
  publishLocal := {},
  com.typesafe.sbt.pgp.PgpKeys.publishSigned := {},
  com.typesafe.sbt.pgp.PgpKeys.publishLocalSigned := {},
  publishArtifact := false,
  publishTo := Some(Resolver.file("Unused transient repository",file("target/unusedrepo")))
)

lazy val publishingSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra := (
    <url>https://github.com/jokade/scalanative-qt5</url>
    <licenses>
      <license>
        <name>MIT License</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:jokade/scalanative-qt5</url>
      <connection>scm:git:git@github.com:jokade/scalanative-qt5.git</connection>
    </scm>
    <developers>
      <developer>
        <id>jokade</id>
        <name>Johannes Kastner</name>
        <email>jokade@karchedon.de</email>
      </developer>
    </developers>
  )
)
 
