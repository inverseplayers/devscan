package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import Css.*
import CssCase.*
import CssCase.Target.*
import CssCase.Color.*
import CssCase.Point.*

enum Cell:
  case Button(data: String = "", css: Tailwind) extends Cell
  case NavDetail_Row(data: String = "", css: String = "cell") extends Cell
  case None(data: String = "", css: String = "cell") extends Cell

  def view(model: Model): Html[Msg] =
    button(
      `class` := s"$button_sub"
    )(
      span(
        `class` := s"$icon" + s" ${Css.text.white}"
      )("content_copy")
    )

object gen:
  def cell(cells: Cell*) = cells
    .map(cell =>
      cell match
        case Cell.Button(data, css) =>
          div(
            `class` := s"$button_container"
          )(
            button(
              `class` := s"$button_sub"
            )(
              span(
                `class` := s"$icon" + genCss(css)
              )(data)
            )
          )
        case Cell.NavDetail_Row(data, css) =>
          div(
            `class` := s"${genCss(Tailwind(_Text, _Gray, _400))} pl-[20px] pt-[4px] text-[12px] font-[500]"
          )(
            data
          )
        case _ => div()
    )
    .toList
