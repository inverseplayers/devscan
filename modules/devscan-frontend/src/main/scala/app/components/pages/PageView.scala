package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import css.*

object PageView:

  def view(model: Model): Html[Msg] =
    div(`class` := s"$page")(
      "페이지 입니다"
    )
