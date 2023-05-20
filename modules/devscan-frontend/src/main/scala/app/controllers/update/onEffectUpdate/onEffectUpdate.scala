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
import app.JsonData.getJsonData
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
        // Cmd.Emit(
        //   OnEffectMsg.On_MiniMap_ClickAfterUpdate(element)
        //   // 1.millis
        // )
      )
    case OnEffectMsg.On_MiniMap_ClickAfterUpdate(element) =>
      (
        model.copy(isMinimap =
          Dom.select("json-area").clientHeight > window.innerHeight
        ),
        Cmd.None
      )
    case OnEffectMsg.On_KeyUp_Json(string) =>
      println("string")
      println(string)
      // println(model.json)
      val a = model.json.hcursor
      (
        model.copy(
          // 1.map dom 에서 데이터 뽑기
          map_dom = model.map_dom +
            (
              model.current_jsonkey.toString()
              // List("s").toString()
                -> string
                  .replaceAll(raw"""\\\"""", raw"")
                  .replaceAll(raw"""\"""", raw"")
                  .split(raw"\\n")
                  .toList
                  .map(d => {
                    div(`class` := "pl-1")(d)
                  })
            ),

          // json = getJsonData("""{"jsonString": "none"}""")
          // 2. json 에서 데이터 뽑기
          json = model.json.hcursor
            .downField("backend777")
            .downArray
            .downField("이력서1")
            .withFocus(_.mapString(s => string))
            .top
            .get
        ),
        Cmd.None
      )
    case OnEffectMsg.None =>
      (
        model,
        Cmd.None
      )
