package app
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.ModelPipe.*

object OnEffectUpdate:
  def update(model: Model): OnEffectMsg => (Model, Cmd[IO, Msg]) =
    case OnEffectMsg.OnMouseOver(isOver: Boolean) =>
      (
        model.copy(isOver = isOver),
        Cmd.None
      )
    case OnEffectMsg.OnMouseOut(isOver: Boolean) =>
      (
        model.copy(isOver = isOver),
        Cmd.None
      )
