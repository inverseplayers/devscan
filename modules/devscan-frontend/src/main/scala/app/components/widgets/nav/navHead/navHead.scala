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
  val a = {
    println(C.sample3)
    println(C.sample3)
    // val a = genCss _Text
    add(1)(2)
    // T.Text + Color.Gray + Point.P300
    // T.
  }

  def view(model: Model): Html[Msg] =
    nav(`class` := s"$navs")(
      gen.cell(
        Cell.Button(
          "content_copy"
          // s"${Css.text.gray(400)}  ${genCss _Text}"
        ),
        Cell.Button(
          "search"
          // s"${Css.text.gray(400)}  ${genCss(T.Text, Color.Gray, Point.P300)}"
        )
      )
    )
