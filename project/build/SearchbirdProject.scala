import sbt._
import Process._
import com.twitter.sbt._
import de.element34.sbteclipsify._

class SearchbirdProject(info: ProjectInfo) extends StandardServiceProject(info)
  with CompileThriftRuby
  with CompileThriftJava
  with CompileThriftScroogeMixin
  with NoisyDependencies
  with DefaultRepos
  with SubversionPublisher
  with PublishSourcesAndJavadocs
  with PublishSite
  with Eclipsify
{
  val finagleVersion = "1.9.12"

  val finagleC = "com.twitter" % "finagle-core" % finagleVersion
  val finagleT = "com.twitter" % "finagle-thrift" % finagleVersion
  val finagleO = "com.twitter" % "finagle-ostrich4" % finagleVersion

  // thrift
  val scrooge_runtime = "com.twitter" % "scrooge-runtime" % "1.0.3"
  val libthrift = "thrift" % "libthrift" % "0.5.0"
  val util = "com.twitter" % "util" % "1.11.2"

  val slf4jVersion = "1.5.11"
  val slf4jApi = "org.slf4j" % "slf4j-api" % slf4jVersion withSources() intransitive()
  val slf4jBindings = "org.slf4j" % "slf4j-jdk14" % slf4jVersion withSources() intransitive()

  // for tests
  val specs = "org.scala-tools.testing" % "specs_2.8.1" % "1.6.7" % "test" withSources()
  val jmock = "org.jmock" % "jmock" % "2.4.0" % "test"
  val hamcrest_all = "org.hamcrest" % "hamcrest-all" % "1.1" % "test"
  val cglib = "cglib" % "cglib" % "2.1_3" % "test"
  val asm = "asm" % "asm" % "1.5.3" % "test"
  val objenesis = "org.objenesis" % "objenesis" % "1.1" % "test"

  override def mainClass = Some("com.twitter.searchbird.Main")
  override def subversionRepository = Some("http://svn.local.twitter.com/maven")
}
