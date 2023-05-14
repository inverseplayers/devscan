package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import Css.*
import app.JsonData.resume

object PageView:

  def view(model: Model): Html[Msg] =
    div(`class` := s"$page")(
      p(`class` := "text-white")(model.current_depth)
      // p(`class` := "text-white")(resume)
    )
