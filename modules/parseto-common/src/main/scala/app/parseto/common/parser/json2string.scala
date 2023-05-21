package app.parseto.common.parser
import io.circe.{Json, JsonObject}
import scala.util.chaining.*

def getObj(json: Json) = json.asObject.getOrElse(JsonObject.empty)

def json2string_asType(json: Json) = json
  .fold(
    Json.Null,
    _ => "JsonBoolean",
    _ => "JsonNumber",
    _ => "String",
    _ => "JsonArray",
    _ => "JsonObject"
  )
  .getClass
  .getSimpleName

def json2string_foldArray(key: Int)(json: Json) = json.fold(
  "null",
  _.toString,
  _.toString,
  _.toString,
  arr => s"${arr(key)}",
  obj => s"Object[${obj.size}]"
)

def getValue(json: Json) = json.fold(
  "null",
  _.toString,
  _.toString,
  _.toString,
  arr => s"Array[${arr.length}]",
  obj => s"Object[${obj.size}]"
)

def json2json_foldObject(key: String)(json: Json) = json
  .pipe(getObj)(key)
  .get

def json2string_foldable(keys: List[String])(json: Json): String =
  keys.length match
    case 0 => json.toString
    case _ =>
      keys.head.toString().forall(_.isDigit) match
        case false =>
          json
            .pipe(json2json_foldObject(keys.head))
            .pipe(json2string_foldable(keys.tail))
        case true =>
          json
            .pipe(json2string_foldArray(keys.head.toInt))
            .pipe(string2json)
            .pipe(json2string_foldable(keys.tail))
