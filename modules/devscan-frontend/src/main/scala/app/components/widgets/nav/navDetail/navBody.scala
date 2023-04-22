package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
// import css.*

object NavBodyView:
  def render(model: Model): Html[Msg] =
    FileSearchNavView.view(model)

  def view(model: Model): Html[Msg] =
    NavBodyView.render(model)
