package parseto.common.tester

import parseto.common.data.JsonString.*
import parseto.common.parser.Parser.*
import parseto.common.function.Log.*

object Tester:
  val test_json2string =
    // """{"과일": ["사과","딸기","포도","배"]}""" => "딸기"
    log(json2string_foldable(List("과일", "0"))(log(string2json(fruits))))
