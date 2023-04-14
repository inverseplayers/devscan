package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*

object NavDetailView:

  def view(model: Model): Html[Msg] =
    div(`class` := "text-2xl font-bold bg-slate-300")(
      "네비입니다 입니다"
    )
