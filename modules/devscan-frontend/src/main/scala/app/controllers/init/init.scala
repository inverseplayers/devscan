package app
import tyrian.*
import cats.effect.IO
import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal
import tyrian.Html.*
import org.scalajs.dom.*

@js.native
@JSGlobal("CodeMirror")
object CodeMirror extends js.Object {
  def apply(
      element: js.Any,
      options: js.Dictionary[js.Any]
  ): CodeMirrorInstance = js.native
}

@js.native
trait CodeMirrorInstance extends js.Object {
  def getValue(): String = js.native
  def setValue(value: String): Unit = js.native
}

object Init:
  def init(flags: Map[String, String]): (Model, Cmd[IO, Msg]) =
    (
      Model(
        appStates = List(
          StateCase(
            pageCase = PageCase.Page_Finders(),
            number = 1
          )
        ),
        pointer = 1,
        editor = {
          val editorElement = document.querySelector(".dom-input")

          val options = js.Dictionary[js.Any](
            "lineNumbers" -> true,
            "tabSize" -> 2,
            "mode" -> "javascript"
            // "theme" -> "monokai"
          )
          val editor = CodeMirror(editorElement, options)
          editor
        }
      ),
      Cmd.None
    )
