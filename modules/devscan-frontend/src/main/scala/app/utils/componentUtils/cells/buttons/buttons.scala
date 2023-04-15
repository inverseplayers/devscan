package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import css.*

enum Cell:
  case Button(data: String, css: String = "cell") extends Cell

  def view(model: Model): Html[Msg] =
    button(
      `class` := s"$button_sub"
    )(
      span(
        `class` := s"$icon" + s" ${css.text.white}"
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
                `class` := s"$icon" + s" $css"
              )(data)
            )
          )
    )
    .toList
