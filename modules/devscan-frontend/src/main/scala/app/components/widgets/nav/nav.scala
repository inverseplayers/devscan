package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import css.*

object NavView:

  def view(model: Model): Html[Msg] =
    div(`class` := s"$nav_container")(
      NavHeadView.view(model),
      NavBodyView.view(model)
    )
