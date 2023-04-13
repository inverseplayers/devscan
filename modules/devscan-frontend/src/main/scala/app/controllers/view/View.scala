package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*

object View:

  def view(model: Model): Html[Msg] =
    div(
      button(onClick(Msg.Decrement))("-"),
      div(model.toString),
      button(onClick(Msg.Increment))("+")
    )
    // div(
    //   div(`class` := "main")(
    //     NavView.view(model),
    //     PageView.view(model)
    //   )
    // )
