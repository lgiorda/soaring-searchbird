package com.twitter.searchbird

import java.util.concurrent.Executors
import scala.collection.mutable
import com.twitter.util._
import config._
import com.twitter.searchbird.thrift._

class SearchbirdServiceImpl(config: SearchbirdServiceConfig, index: Index) extends SearchbirdService.ThriftServer {
  val serverName = "Searchbird"
  val thriftPort = config.thriftPort

  def get(key: String) = index.get(key)
  def put(key: String, value: String) =
    index.put(key, value) flatMap { _ => Future.Unit }
  def search(query: String) = index.search(query)
}
