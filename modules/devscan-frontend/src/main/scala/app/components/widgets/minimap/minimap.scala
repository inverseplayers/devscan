package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import Css.*

object Minimap:

  def view(model: Model): Html[Msg] =
    model.isMinimap match
      case true =>
        div(`class` := s"minimap-absolute")(
          div(`class` := s"minimap-doc")(),
          div(
            `class` := s"minimap-window",
            style(Style("background" -> "blue"))
          )()
        )
      case _ => div()
