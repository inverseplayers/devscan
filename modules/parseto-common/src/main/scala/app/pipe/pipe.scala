package parseto.common.pipe

import scala.util.chaining.*
import parseto.common.data.*
import parseto.common.function.Log.*
import parseto.common.parser.Parser.*

object Pipe:
  def parseJsonString1 = JsonString.ex_fruits
    .pipe(log2("ex_fruits"))
    .pipe(string2json) // [CC-convert-create]
    .pipe(
      // _
      // json2json_update(List("직업", "공무원"), "2급")
      json2json_update(List("과일", 2), "딸기-update")
    ) // [IU-identity-update]
  // .pipe(json => json2string(json, List("직업"))) // [CR-convert-read]
  // .pipe(string2json)
  // .pipe(json => json2string(json, List("의사"))) // [CR-convert-read]
