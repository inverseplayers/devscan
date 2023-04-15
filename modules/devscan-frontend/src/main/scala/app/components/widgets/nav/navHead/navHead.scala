package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import css.*

object NavHeadView:

  def view(model: Model): Html[Msg] =
    nav(`class` := s"$navs")(
      gen.cell(
        Cell.Button("content_copy", s"${css.text.white}"),
        Cell.Button("search", s"${css.text.gray}")
      )
    )
