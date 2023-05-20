package parseto.common.pipe

import scala.util.chaining.*
import parseto.common.data.*
import parseto.common.function.Log.*
import parseto.common.parser.Parser.*
import io.circe.Json

object Pipe:
  def pipe_string2json2json_jsonUpdateAsKey(
      string: String,
      kv: (List[String | Int], String)
  ) = string.pipe(string2json).pipe(json2json_update(kv(0), kv(1)))

  def parseJsonString1 =
    pipe_string2json2json_jsonUpdateAsKey(
      JsonString.ex_fruits,
      (List("과일", 1), "d")
    )

  def parseJsonString_ex1 = JsonString.ex_fruits
    .pipe(log2("ex_fruits"))
    .pipe(string2json) // [CC-convert-create]
    .pipe(
      // _
      // json2json_update(List("직업", "공무원"), "2급")
      json2json_update(List("과일", 1), "d")
    ) // [IU-identity-update]
  // .pipe(json => json2string(json, List("직업"))) // [CR-convert-read]
  // .pipe(string2json)
  // .pipe(json => json2string(json, List("의사"))) // [CR-convert-read]
