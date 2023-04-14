package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import css.*

object View:
  def view(model: Model): Html[Msg] =
    div(`class` := s"${css.main}")(
      NavView.view(model),
      div(`class` := s"material-symbols-outlined")()
    )
