package app
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.ModelPipe.*

object DepthUpdate:
  def update(model: Model): DepthMsg => (Model, Cmd[IO, Msg]) =
    case DepthMsg.OnClick(depth: Int, key: String) =>
      depth match
        case _ =>
          (
            model.copy(
              depth = model.depth.copy(d1 = List(key))
            ),
            Cmd.None
          )
