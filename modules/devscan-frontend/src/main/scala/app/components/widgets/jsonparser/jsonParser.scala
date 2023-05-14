package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import Css.*
import scala.util.chaining.*
import scala.scalajs.js.Dynamic.{global => g}
import io.circe.{Json, JsonObject}
import app.JsonData.*
import app.CssCase.Target.*
import app.CssCase.Color.*
import app.CssCase.Point.*
import app.CssCase.*

object JsonParser:

  import scala.scalajs.js
  def getObj(json: Json) = json.asObject.getOrElse(JsonObject.empty)

  def getEntries(obj: JsonObject) = obj.toIterable.toList
  def convertJsonArrayToEntries(json: Json) = json.asArray.toList
    .map(_.zipWithIndex.map { case (value, index) =>
      (index.toString, value)
    })
    .flatten

  def pipeGetEntries(json: Json) =
    json.asObject.getOrElse(JsonObject.empty) match
      case JsonObject.empty => json.pipe(convertJsonArrayToEntries)
      case _                => json.pipe(getObj).pipe(getEntries)

  def getObjType(json: Json) = json
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

  def getValue(json: Json) = json.fold(
    "null",
    _.toString,
    _.toString,
    _.toString,
    arr => s"Array[${arr.length}]",
    obj => s"Object[${obj.size}]"
  )

  def template(
      key: String,
      json: Json,
      indent: String,
      depth: Int,
      model: Model,
      current_jsonkey: List[String | Int]
  ): Html[Msg] = {
    val kv = s"$key : ${getValue(json)}"
    div(
      `class` := s"text-white"
      // onClick()
    )(
      div(
      )(
        gen.cell(
          Cell.Json_Row(
            indent + kv,
            "cell",
            depth,
            key,
            model.current_depth,
            current_jsonkey ::: List(key),
            model
          )
        )
      ), {
        model.depth(depth).get(key).getOrElse(false) match
          case false =>
            div()
          case true =>
            div()(
              {
                pipeGetEntries(json).map((k, v) => {
                  template(
                    k,
                    v,
                    indent + "ㅤ",
                    depth + 1,
                    model, {
                      // println("current_jsonkey ::: List(k)")
                      // println(current_jsonkey ::: List(key))
                      current_jsonkey ::: List(key)
                    }
                  )
                })
              }
            )

      }
    )
  }

  def view(model: Model): Html[Msg] =
    template("구인", model.json, "", 0, model, List())
