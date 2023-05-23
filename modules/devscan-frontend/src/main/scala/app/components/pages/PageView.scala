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
            // lazy_log()
            List(
              model
                .pipe(json2dom),
              raw"     ~~~~안녕하세요     my name is.."
                .pipe(string2string)
                .pipe(string2List)
                .tap(
                  log
                )
                .pipe(listString2dom),
              List(v),
              List(pre(vstring))
            )(3)
          }
        )
      )
    )
