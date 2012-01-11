package com.twitter.searchbird

import com.twitter.ostrich.admin.RuntimeEnvironment

import com.twitter.searchbird.thrift._

object Main {
  def main(args: Array[String]) {
    val env = RuntimeEnvironment(this, args)
    val service = env.loadRuntimeConfig[SearchbirdService.ThriftServer]
    service.start()
  }
}

