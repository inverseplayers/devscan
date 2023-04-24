package app
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.ModelPipe.*

object PageUpdate:
  def update(model: Model): PageMsg => (Model, Cmd[IO, Msg]) =
    case PageMsg.PreUpdate(page: PageCase) =>
      page match
        case _ =>
          (
            model.copy(
              pointer = get_latest_number(model) + 1,
              appStates = model.appStates ++ Seq(
                StateCase(
                  number = get_latest_number(model) + 1,
                  pageCase = page == find_current_PageCase(model) match
                    case true => PageCase.Page_Nopage()
                    case _    => page
                )
              )
            ),
            Cmd.None
          )
