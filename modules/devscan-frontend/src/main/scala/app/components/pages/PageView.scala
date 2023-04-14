package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*

object PageView:

  def view(model: Model): Html[Msg] =
    div(`class` := "text-2xl font-bold bg-slate-300")(
      "페이지 입니다"
    )
