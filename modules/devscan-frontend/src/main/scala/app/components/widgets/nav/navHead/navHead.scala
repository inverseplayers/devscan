package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
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
          PageCase.Page_Finders(),
          List(Tailwind(_Text, _Gray, _500), Tailwind(_Text, _Gray, _100)),
          model
        ),
        Cell.Button(
          PageCase.Page_Searchs(),
          List(Tailwind(_Text, _Gray, _500), Tailwind(_Text, _Gray, _100)),
          model
        )
      )
    )
