package app.parseto.common.parser
import io.circe.parser.*
import io.circe.syntax.*
import io.circe.{Json, JsonObject}
import scala.util.chaining.*
import io.circe.Encoder.encodeString
import io.circe.ACursor
import io.circe.HCursor

def cursor2cursor_selector(key: Int)(cursor: ACursor) =
  key match
    case 0 => cursor
    case 1 => cursor.right
    case _ =>
      (1 to key).foldLeft(cursor) { (z, i) =>
        z.right
      }

def hcursor2cursor_byKey(hcursor: HCursor | ACursor, key: String | Int) =
  key match
    case key: String =>
      Some(
        hcursor.downField(key)
      )
    case key: Int =>
      Some(
        hcursor.downArray.pipe(cursor2cursor_selector(key.toInt))
      )

def cursor2cursor =
  (cursor: Option[ACursor], json: Json, key: String) =>
    val _key = string_digit_2int(key)
    cursor match
      case None =>
        hcursor2cursor_byKey(json.hcursor, _key)

      case _ =>
        hcursor2cursor_byKey(cursor.get, _key)

def cursor2json =
  (cursor: Option[ACursor], value: String) =>
    cursor.get
      .withFocus(s =>
        s.toString.asJson.mapString(s => value.asJson.asString.get)
      )
      .top
      .get

def json2json_update(
    keys: List[String],
    value: String,
    acc: Option[ACursor] = None
)(
    json: Json
): Json =
  keys.length match
    case 0 => json
    case 1 =>
      json2json_update(
        keys.tail,
        value,
        acc
      )(
        cursor2json(cursor2cursor(acc, json, keys.head), value)
      )

    case _ =>
      json2json_update(
        keys.tail,
        value,
        cursor2cursor(acc, json, keys.head)
      )(
        json
      )
