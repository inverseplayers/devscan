package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*

object View:
  def view(model: Model): Html[Msg] =
    div(`class` := s"${}")(
      div("안녕")
    )
