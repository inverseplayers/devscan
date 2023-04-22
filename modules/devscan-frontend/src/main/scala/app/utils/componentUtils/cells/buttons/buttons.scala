package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import Css.*
import CssCase.*
import CssCase.Target.*
import CssCase.Color.*
import CssCase.Point.*

enum Cell:
  case Button(pagecase: PageCase, css: List[Tailwind], model: Model)
      extends Cell
  case NavDetail_Row(data: String = "", css: String = "cell") extends Cell
  case Json_Row(data: String = "", css: String = "cell") extends Cell
  case None(data: String = "", css: String = "cell") extends Cell

  // def view(model: Model): Html[Msg] =
  //   button(
  //     `class` := s"$button_sub"
  //   )(
  //     span(
  //       `class` := s"$icon" + s" ${Css.text.white}"
  //     )("content_copy")
  //   )

object gen:
  def cell(cells: Cell*) = cells
    .map(cell =>
      cell match
        case Cell.Button(pagecase, css, model) =>
          div(
            `class` := s"$button_container"
          )(
            button(
              `class` := s"$button_sub",
              onClick(PageMsg.PreUpdate(pagecase))
            )(
              span(
                `class` := s"$icon" + genCss({
                  PageCasePipe.in_Name(pagecase) == ModelPipe.find_name(
                    model
                  ) match
                    case true  => css(1)
                    case false => css(0)

                })
              )(PageCasePipe.in_Name(pagecase))
            )
          )
        case Cell.NavDetail_Row(data, css) =>
          div(
            `class` := s"${genCss(Tailwind(_Text, _Gray, _400))} pl-[2px] pt-[4px] text-[12px] font-[500]"
          )(
            data
          )
        case Cell.Json_Row(data, css) =>
          div(
            // onClick(() => ""),
            `class` := s"${genCss(Tailwind(_Text, _Gray, _400))} pl-[2px] pt-[4px] text-[12px] font-[500]"
          )(
            data
          )
        case _ => div()
    )
    .toList
