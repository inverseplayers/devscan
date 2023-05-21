package parseto.common.tester
import scala.util.chaining.*

import parseto.common.data.JsonString.*
import parseto.common.parser.Parser.*
import parseto.common.function.Log.*

object Tester:
  val test_json2string =
    string2json(log(fruits)) // """{"과일": ["사과","딸기","포도","배"]}"""
      .pipe(log(json2string_foldable(List("과일", "0")))) // "딸기"
