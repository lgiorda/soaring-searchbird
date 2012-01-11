import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
 
  override def repositories = super.repositories ++ Set(
      "twitter.com" at "http://maven.twttr.com/",
      "scala-tools" at "http://scala-tools.org/repo-releases/",
      "freemarker" at "http://freemarker.sourceforge.net/maven2/",
      "codehaus" at "http://repository.codehaus.org",
      "glassfish" at "http://download.java.net/maven/glassfish"      
    )
  
  override def ivyRepositories = Seq(Resolver.defaultLocal(None)) ++ repositories

  lazy val eclipsify = "de.element34" % "sbt-eclipsify" % "0.7.0"
  val standardProject = "com.twitter" % "standard-project" % "0.12.12"
  val sbtThrift = "com.twitter" % "sbt-thrift" % "2.0.2"
  val sbtScrooge = "com.twitter" % "sbt-scrooge" % "1.1.1"


  }
