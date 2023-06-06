package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import Css.*

object View:
  def view(model: Model): Html[Msg] =
    div(`class` := s"${Css.main}")(
      NavView.view(model),
      div(`class` := s"w-[100%] ${model.current_jsonkey}")(PageView.view(model))
    )
