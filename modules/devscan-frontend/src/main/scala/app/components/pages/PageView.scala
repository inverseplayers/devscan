package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import Css.*
import app.JsonData.resume

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
            println("model.dom")
            println(model.current_jsonkey.toString())
            println(model.dom)
            val b = model.map_dom(model.current_jsonkey.toString())
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
