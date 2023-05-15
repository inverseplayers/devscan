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
        div(p(`class` := "text-white")(model.current_jsonkey.toString())),
        div(
          p(`class` := "text-white")(
            {
              model.current_jsonValue
                .replaceAll(raw"""\\\"""", raw"")
                .split(raw"\\n")
                .toList
                .map(d => {
                  div(d)
                })
            }
          )
        )
      )
    )
