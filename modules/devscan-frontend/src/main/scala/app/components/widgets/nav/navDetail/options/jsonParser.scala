package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import Css.*
import scala.util.chaining.*

import scala.scalajs.js.Dynamic.{global => g}

import io.circe.{Json, JsonObject}
import app.JsonData.getJsonData
import app.JsonData.jsonString

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

  def template(key: String, json: Json): Html[Nothing] =
    div(`class` := "text-white")(
      div()(s"$key : ${getValue(json)}"),
      div()(
        {
          pipeGetEntries(json).map((k, v) => {
            template(k, v)
          })
        }
      )
    )

  def view(model: Model): Html[Msg] = template("JSON", getJsonData(jsonString))
