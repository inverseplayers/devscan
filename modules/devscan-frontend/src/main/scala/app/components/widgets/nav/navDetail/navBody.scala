package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import css.*

object NavBodyView:

  def view(model: Model): Html[Msg] =
    div(`class` := s"$nav_detail")(
      "네비입니다 입니다"
    )
