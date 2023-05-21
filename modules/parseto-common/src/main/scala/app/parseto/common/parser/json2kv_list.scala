package app.parseto.common.parser
import scala.util.chaining.*
import scala.scalajs.js.Dynamic.{global => g}
import io.circe.{Json, JsonObject}

object Helper:
  def getEntries(obj: JsonObject) = obj.toIterable.toList
  def convertJsonArrayToEntries(json: Json) =
    json.asArray.toList
      .map(_.zipWithIndex.map { case (value, index) =>
        (index.toString, value)
      })
      .flatten

def json2kv_list(json: Json) =
  json.asObject.getOrElse(JsonObject.empty) match
    case JsonObject.empty =>
      json
        .pipe(Helper.convertJsonArrayToEntries)
    case _ =>
      json
        .pipe(getObj)
        .pipe(Helper.getEntries)
