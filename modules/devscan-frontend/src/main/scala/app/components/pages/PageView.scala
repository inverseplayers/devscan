package app
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import Css.*
import app.parseto.common._api.*
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
            log2("pageview.json2string key = list()")(
              json2string_foldable(List("app", "구인"))(model.json)
            )
            // log2("model.current_jsonkey")(model.current_jsonkey)
            json2string_foldable(model.current_jsonkey.tail)(model.json)

          }
        )
      )
    )
