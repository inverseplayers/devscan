package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*

object View:
  def view(model: Model): Html[Msg] =
    div(`class` := s"${"bg-black h-screen w-screen"}")(
      div(`class` := s"${"text-white"}")("안녕")
    )
