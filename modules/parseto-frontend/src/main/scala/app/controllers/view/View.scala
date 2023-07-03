package parseto
import tyrian.*
import cats.effect.IO

import tyrian.Html.*
import app.parseto.common._api.*

object View:
  def view(model: Model): Html[Msg] =
    div(`class` := s"")(
      PageView.view(model)
    )
