package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import Css.*

object ScrollView:

  def view(model: Model): Html[Msg] =
    div(`class` := s"scroll-bar-absolute")(
      div(`class` := s"scroll-bar-fixed")()
    )
