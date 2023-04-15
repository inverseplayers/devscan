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

object NavHeadView:
  def view(model: Model): Html[Msg] =
    nav(`class` := s"$navs")(
      gen.cell(
        Cell.Button(
          "content_copy",
          Tailwind(_Text, _Gray, _500)
        ),
        Cell.Button(
          "search",
          Tailwind(_Text, _Gray, _100)
        )
      )
    )
