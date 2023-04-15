package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import Css.*

object FileSearchNavView:

  def view(model: Model): Html[Msg] =
    div(`class` := s"$nav_detail")(
      gen.cell(
        Cell.NavDetail_Row(TextGen.NavDetail.title),
        Cell.NavDetail_Row("> 대분류"),
        Cell.NavDetail_Row("ㅤ> 중분류"),
        Cell.NavDetail_Row("ㅤㅤ> 소분류")
      )
    )
