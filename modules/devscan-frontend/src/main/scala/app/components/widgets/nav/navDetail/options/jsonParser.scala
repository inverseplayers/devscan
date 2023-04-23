package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import Css.*
import scala.util.chaining.*
import scala.scalajs.js.Dynamic.{global => g}
import io.circe.{Json, JsonObject}
import app.JsonData.*

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
      model: Model
  ): Html[DepthMsg | PageMsg] = {

    // modle 에 foldable = [ d1: [c1,c2],d2:[c1,c2]...]
    // foldable.d1 include c1
    //

    div(`class` := "text-white")(
      // div()(model.depth(0)("Json1")),
      div(
      )(
        gen.cell(
          Cell.Json_Row(
            indent + s"$key : ${getValue(json)}",
            "cell",
            depth,
            key
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
                  template(k, v, indent + "ㅤ", depth + 1, model)
                })
              }
            )

      }
    )
  }

  def view(model: Model): Html[Msg] =
    template("구인", getJsonData(jsonString), "", 0, model)
