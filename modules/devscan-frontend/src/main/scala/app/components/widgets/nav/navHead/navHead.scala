package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import css.*

object NavHeadView:

  def view(model: Model): Html[Msg] =
    nav(`class` := s"$navs")(
      div(
        `class` := s"$button_container"
      )(
        button(
          `class` := s"$button_sub"
        )(
          span(
            `class` := s"$icon" + s" ${css.text.white}"
          )("content_copy")
        )
      ),
      div(
        `class` := s"$button_container"
      )(
        button(
          `class` := s"$button_sub"
        )(
          span(
            `class` := s"$icon" + s" ${css.text.gray}"
          )("search")
        )
      )
    )
