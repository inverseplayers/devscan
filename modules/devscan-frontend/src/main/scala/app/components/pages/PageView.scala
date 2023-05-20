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
            val b =
              ex_fruits
                .pipe(string2json)
                .pipe(s =>
                  json2string(model.json, model.current_jsonkey.drop(1))
                )

            // val b = model.map_dom(List("s").toString())
            b
            // b.toString()
            // val x = model.current_jsonValue
            //   .replaceAll(raw"""\\\"""", raw"")
            //   .replaceAll(raw"""\"""", raw"")
            //   .split(raw"\\n")
            //   .toList
            //   .map(d => {
            //     div(`class` := "pl-1")(d)
            //   })
            // x
          }
        )
      )
    )
