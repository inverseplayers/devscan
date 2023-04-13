package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*

object View:

  def view(model: Model): Html[Msg] =
    div(`class` := "text-2xl font-bold bg-slate-300")(
      button(onClick(Msg.Decrement))("-"),
      div(model.toString),
      button(onClick(Msg.Increment))("+")
    )
