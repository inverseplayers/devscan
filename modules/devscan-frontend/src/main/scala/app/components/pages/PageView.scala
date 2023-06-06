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
          `class` := s"dom-input text-white block editorContainer   ${model.current_jsonkey}",
          contentEditable := "true"
        )(
          // ""
          // v_string_short
          // {
          //   // // lazy_log()
          //   Map(
          //     "m" -> model.json
          //       // json select
          //       .pipe(json2string_foldable(model.current_jsonkey.tail))
          //       // 따옴표 제거
          //       .pipe(string2string)
          //       // 줄바꿈 => 리스트로 쪼개기
          //       .pipe(string2List)
          //       .pipe(listString2dom),
          //     "2" -> model
          //       .pipe(json2dom),
          //     "3" -> raw"string test regex"
          //       .pipe(string2string)
          //       .pipe(string2List)
          //       .tap(
          //         log
          //       )
          //       .pipe(listString2dom),
          //     "4" -> List(v),
          //     "5" -> v_string_short
          //       .pipe(string2string)
          //       .pipe(string2List)
          //       .pipe(listToHtml),
          //     "json|>html" -> model.json
          //       // json select
          //       .pipe(json2string_foldable(model.current_jsonkey.tail))
          //       // 따옴표 제거
          //       .pipe(string2string)
          //       // .pipe(log2("string2string"))
          //       .pipe(string2List)
          //       .pipe(listToHtml),
          //     "6" -> List(pre(vstring))
          //   )("json|>html")
          // }
        )
      )
    )
