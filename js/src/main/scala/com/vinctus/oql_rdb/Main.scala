package com.vinctus.oql_rdb

import scala.scalajs.js
import js.Dynamic.{global => g}

@main def run(): Unit =
  g.require("source-map-support").install() // so we get more informative stack traces
