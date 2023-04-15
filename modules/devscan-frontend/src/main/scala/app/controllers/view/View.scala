package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import Css.*

object View:
  def view(model: Model): Html[Msg] =
    div(`class` := s"${Css.main}")(
      NavView.view(model),
      PageView.view(model)
    )
