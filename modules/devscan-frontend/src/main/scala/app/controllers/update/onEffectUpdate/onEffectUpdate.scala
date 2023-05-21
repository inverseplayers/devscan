package app
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import org.scalajs.dom.document
import scala.util.chaining.*
import concurrent.duration.DurationInt

import tyrian.*
import cats.effect.IO
import app.ModelPipe.*
import scala.concurrent.Future
// import scala.scalajs.js.Promise
import scala.scalajs.js.Thenable.Implicits._
import scala.concurrent.Promise
import parseto.common.parser.Parser.json2json_update
import parseto.common.parser.Parser.string2json
import parseto.common.function.Log.*
// import app.Model.map_dom

object OnEffectUpdate:

  def delay(milliseconds: Int): Future[Unit] = {
    val p = Promise[Unit]()
    js.timers.setTimeout(milliseconds) {
      p.success(())
    }
    p.future
  }
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
    case OnEffectMsg.On_MiniMap_Click(element) =>
      (
        model.copy(),
        Cmd.emitAfterDelay(
          OnEffectMsg.On_MiniMap_ClickAfterUpdate(element),
          10.millis
        )
      )
    case OnEffectMsg.On_MiniMap_ClickAfterUpdate(element) =>
      (
        model.copy(isMinimap =
          Dom.select("json-area").clientHeight > window.innerHeight
        ),
        Cmd.None
      )
    case OnEffectMsg.On_KeyUp_Json(string) =>
      (
        model.copy(
          json = json2json_update(
            model.current_jsonkey.drop(1),
            string
          )(model.json)
        ),
        Cmd.None
      )
    case OnEffectMsg.None =>
      (
        model,
        Cmd.None
      )
