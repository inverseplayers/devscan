package parseto
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO

object PageUpdate:
  def update(model: Model): PageMsg => (Model, Cmd[IO, Msg]) =
    case PageMsg.PreUpdate(page: PageCase) =>
      page match
        case _ =>
          (
            model.copy(
              pointer = 1
            ),
            Cmd.None
          )
