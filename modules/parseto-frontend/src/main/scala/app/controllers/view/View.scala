package parseto
import tyrian.*
import cats.effect.IO

import tyrian.Html.*
import parseto.common.pipe.*
import parseto.common.function.Log.*
import parseto.common.pipe.Pipe.*

object View:
  def view(model: Model): Html[Msg] =
    div(`class` := s"${"bg-black h-screen w-screen"}")(
      {

        log2("parseJsonString1")(parseJsonString1)

        div(`class` := s"${"text-white"}")(
          parseJsonString1.toString
        )
      }
    )
