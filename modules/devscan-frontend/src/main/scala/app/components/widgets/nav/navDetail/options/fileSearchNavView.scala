package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import Css.*

object FileSearchNavView:

  def view(model: Model): Html[Msg] =
    div(`class` := s"$nav_detail")(
      gen.cell(Cell.NavDetail_Title())
    )
