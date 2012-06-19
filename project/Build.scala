import sbt._
import Keys._
import PlayProject._
import sbt.Defaults._


object ApplicationBuild extends Build {

    import Resolvers._
    import Dependencies._
    import BuildSettings._

    val appName         = "play2-plugin-base"
    val appVersion      = "0.1"

    // Edit this!
    val releases        = "/YOURDIR/maven-repo/release"
    // Edit this!
    val snapshot        = "/YOURDIR/maven-repo/snapshots"

    val appDependencies = Seq(
      // Add your project dependencies here,
    )

    val main = PlayProject(appName, appVersion, appDependencies).settings(
      // Add your own project settings here    
      publishTo := Some(Resolver.file("maven-repo", file(mavenRepository))),
      organization   := buildOrganization
    )
    
    object BuildSettings {

        // Edit this!
        val buildOrganization = "YOURORG"

        val buildVersion      = Option(System.getProperty("play.version")).filterNot(_.isEmpty).getOrElse("2.0-unknown")
        val buildScalaVersion = Option(System.getProperty("scala.version")).getOrElse("2.9.1")
        val buildScalaVersionForSbt = "2.9.1"
        val buildSbtVersion   = "0.11.2"

        val buildSettings = Defaults.defaultSettings ++ Seq (
            organization   := buildOrganization,
            version        := buildVersion,
            scalaVersion   := buildScalaVersion
        )

    }

    object Resolvers {
        import BuildSettings._
        val typesafe = "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
        
        val typesafeReleases = "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/maven-releases/"
        val typesafeSnapshot = "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/maven-snapshots/"
        val typesafeIvyReleases = Resolver.url("Typesafe Ivy Releases Repository", url("http://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns) 
        val typesafeIvySnapshot = Resolver.url("Typesafe Ivy Snapshots Repository", url("http://repo.typesafe.com/typesafe/ivy-snapshots/"))(Resolver.ivyStylePatterns) 
        val playIvyRepository = if (buildVersion.endsWith("SNAPSHOT")) typesafeIvySnapshot else typesafeIvyReleases

        val mavenRepository = if (appVersion.endsWith("SNAPSHOT")) snapshot else releases
    }


    object Dependencies {

        val sbtDependencies = Seq(
            "com.typesafe.config"               %    "config"                   %   "0.2.1"
        )
    }

}
