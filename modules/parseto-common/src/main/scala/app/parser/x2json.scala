package parseto.common.parser
import io.circe.parser.*
import io.circe.syntax.*
import io.circe.{Json, JsonObject}
import scala.util.chaining.*
import parseto.common.function.Log.log2
import io.circe.Encoder.encodeString
import parseto.common.data.JsonString.ex_fruits
import parseto.common.function.Log.log
import io.circe.ACursor
import io.circe.HCursor

object Parser:
  def string_digit_2int(string: String): String | Int =
    string.forall(Character.isDigit) match
      case true  => string.toInt
      case false => string

  def string2json(jsonString: String) =
    decode[Json](jsonString) match {
      case Left(error) => {
        Json.True
      }
      case Right(data) => data
    }

  //  (Key : ["과일",0] , value)
  def json2json_sample(json: Json) =
    json.hcursor
      .downField("과일")
      .downArray
      .withFocus(_.mapString(s => "사과말고 바나나!"))
      .top
      .get

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

  // 이렇게 까지 해야하나
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

  def getObj(json: Json) = json.asObject.getOrElse(JsonObject.empty)

  // getJsonValue(ex_fruits,List("과일"))
  def json2string(json: Json, keys: List[String | Int]): String =
    keys.length match
      case 0 => json.toString
      case _ =>
        keys(0).toString() match
          case d: String if !d.forall(_.isDigit) =>
            json2string(json.pipe(getObj)(d).get, keys.drop(1))
          case d: String if d.forall(_.isDigit) =>
            json2string(
              {
                val a = json.fold(
                  "null",
                  _.toString,
                  _.toString,
                  _.toString,
                  arr => s"${arr(d.toInt)}",
                  obj => s"Object[${obj.size}]"
                )
                string2json(a)
              },
              keys.drop(1)
            )
