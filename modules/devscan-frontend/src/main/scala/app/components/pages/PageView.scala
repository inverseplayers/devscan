package app
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import Css.*
import app.JsonData.resume
import parseto.common.parser.Parser.*
import parseto.common.data.JsonString.ex_fruits
import parseto.common.function.Log.*

object PageView:

  def view(model: Model): Html[Msg] =
    div(`class` := s"$page")(
      div(
        `class` := s"w-[100%]"
      )(
        div(p(`class` := "text-white")(model.current_jsonkey.toString())),
        div(
          `class` := s"dom-input text-white block   ${model.current_jsonkey}",
          contentEditable := "true"
        )(
          {
            log2("model.json")(model.json)
            log2("model.current_jsonkey")(model.current_jsonkey)
            json2string(model.json, model.current_jsonkey.drop(1))

          }
        )
      )
    )
