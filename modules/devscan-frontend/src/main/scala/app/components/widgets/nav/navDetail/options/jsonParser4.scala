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

object JsonParser4:
  import JsonData.jsonData
  import scala.scalajs.js
  def getObj(json: Json) = json.asObject.getOrElse(JsonObject.empty)

  // val a = js.Object.entries(js.Array(1, 2, 3))
  // val b = js.JSON.parse("""{"a": 1 , "b": [1,2,3] , "c": {"a": 2}}""")
  //   .toMap
  //   val myObj = g.Object()
  //   myObj.prop1 = 42
  //   myObj.prop2 = "hello world"

  //   val entries = g.Object.entries(myObj)
  //   entries.foreach { entry =>
  //     val key = entry(0)
  //     val value = entry(1)
  //     println(s"Key: $key, Value: $value")
  //   }

  def getEntries(obj: JsonObject) = obj.toIterable.toList

  def pipeGetEntries(json: Json) = json.pipe(getObj).pipe(getEntries)

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

  def view(model: Model): Html[Msg] = template("JSON", jsonData)
