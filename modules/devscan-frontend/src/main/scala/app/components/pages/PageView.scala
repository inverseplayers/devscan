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
          `class` := "dom-input text-white block   ",
          contentEditable := "true"
          // onKeyDown(e =>
          //   println(e)
          //   // (e.ctrlKey || e.metaKey) && e.key == "s" match
          //   // e == "s" match
          //   //   // e.key == "s" match
          //   //   // e.key == "s" match
          //   //   case true => OnEffectMsg.On_KeyUp_Json("")
          //   //   case _    => OnEffectMsg.None
          //   OnEffectMsg.None
          // )
        )(
          {
            model.current_jsonValue
              .replaceAll(raw"""\\\"""", raw"")
              .replaceAll(raw"""\"""", raw"")
              .split(raw"\\n")
              .toList
              .map(d => {
                div(contentEditable := "true", `class` := "pl-1")(d)
              })
          }
        )
      )
    )
