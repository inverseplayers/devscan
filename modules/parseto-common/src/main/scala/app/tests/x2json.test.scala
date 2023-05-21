package parseto.common.tester

import parseto.common.data.JsonString.*
import parseto.common.parser.Parser.*
import parseto.common.function.Log.*

object Tester:
  val test_json2string =
    log(json2string(log(string2json(fruits)), List("과일", "0")))
