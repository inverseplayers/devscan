package app.parseto.common.parser
import scala.util.chaining.*
import app.parseto.common.function.logs.*
import app.parseto.common.data.JsonString
import app.parseto.common.data.JsonString.*

import io.circe.Json

object Tester:
  val test_json2string_foldable =
    fruits // """{"과일": ["사과","딸기","포도","배"]}"""
      .pipe(string2json)
      .pipe(log)
      .pipe(json2string_foldable(List("과일", "0")))
      .pipe(log) // "딸기"

    def json2json_sample(json: Json) =
      json.hcursor
        .downField("과일")
        .downArray
        .withFocus(_.mapString(s => "사과말고 바나나!"))
        .top
        .get

  def pipe_string2json2json_jsonUpdateAsKey(
      string: String,
      kv: (List[String], String)
  ) = string.pipe(string2json).pipe(json2json_update(kv(0), kv(1)))

  def parseJsonString1 =
    pipe_string2json2json_jsonUpdateAsKey(
      JsonString.ex_fruits,
      (List("과일", "1"), "d")
    )

  def parseJsonString_ex1 = JsonString.ex_fruits
    .pipe(log2("ex_fruits"))
    .pipe(string2json) // [CC-convert-create]
    .pipe(
      json2json_update(List("과일", "1"), "d")
    ) // [IU-identity-update]
