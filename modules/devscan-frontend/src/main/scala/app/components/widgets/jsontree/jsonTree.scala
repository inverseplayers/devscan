package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import Css.*
import scala.util.chaining.*
import scala.scalajs.js.Dynamic.{global => g}
import io.circe.{Json, JsonObject}
import app.CssCase.Target.*
import app.CssCase.Color.*
import app.CssCase.Point.*
import app.CssCase.*
import app.parseto.common._api.*

object JsonTree:
  def template(
      key: String,
      json: Json,
      indent: String,
      depth: Int,
      model: Model,
      current_jsonkey: List[String]
  ): Html[Msg] = {
    div(
      `class` := s"text-white"
    )(
      div(
      )(
        gen.cell(
          Cell.Json_Row(
            indent + s"$key : ${getValue(json)}",
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
                json2kv_list(json).map((k, v) => {
                  template(
                    k,
                    v,
                    indent + "ㅤ",
                    depth + 1,
                    model, {
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
    template("root", model.json, "", 0, model, List())
