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
              model.json
                .pipe(json2string_foldable(model.current_jsonkey.tail))
                .pipe(string2string)
                .pipe(string2List)
                .pipe(listString2dom),
              // raw"~~~~안녕하세요 \n 제이름은 \n ooo 입니다."
              raw"     ~~~~안녕하세요     my name is.."
                .pipe(string2string)
                .pipe(string2List)
                .tap(
                  log
                )
                .pipe(listString2dom)
            )(0)
          }
        )
      )
    )
