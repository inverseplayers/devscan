package app
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import org.scalajs.dom.document
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.ModelPipe.*
import io.circe.Json
import scala.util.chaining.*
import io.circe.JsonObject
import io.circe.parser.decode
import app.parseto.common._api.*

object DepthUpdate:

  def update(model: Model): DepthMsg => (Model, Cmd[IO, Msg]) =
    case DepthMsg.OnClick(
          depth: Int,
          key: String,
          current_jsonkey: List[String]
        ) =>
      val editorElement = document.querySelector(".dom-input")
      editorElement.innerHTML = ""
      // log2("editorContainer")(editorElement)
      // log2("editorContainer")(document)

      val options = js.Dictionary[js.Any](
        "lineNumbers" -> true,
        "tabSize" -> 2,
        "mode" -> "javascript"
        // "theme" -> "monokai"
      )
      val editor: CodeMirrorInstance = CodeMirror(editorElement, options)

      editor.setValue(
        model.json.pipe(
          json2string_foldable(current_jsonkey.tail)
        )
        // "var a = 1"
      )

      log2("eeee")(editor.getValue())
      // log2("editor.getValue()")(editor.getValue())

      depth match
        case _ =>
          (
            model.copy(
              // map_dom = model.copy().map_dom +
              //   (
              //     model.current_jsonkey.toString()
              //     // List("s").toString()
              //       -> json2string(model.copy().json, current_jsonkey.drop(1))
              //         .replaceAll(raw"""\\\"""", raw"")
              //         .replaceAll(raw"""\"""", raw"")
              //         .split(raw"\\n")
              //         .toList
              //         .map(d => {
              //           div(`class` := "pl-1")(d)
              //         })
              //   ),
              current_jsonkey = current_jsonkey,
              current_jsonValue =
                model.json.pipe(json2string_foldable(current_jsonkey.tail)),
              current_depth = s"$depth:$key",
              depth = {
                val a = model.depth.zipWithIndex.map((d, i) => {
                  depth == i match
                    // 키가 없으면 키를 true로 넣고, 키가 있으면 키값을 not 연산하여서 집어넣는다
                    case true =>
                      d.contains(key) match
                        case true  => d + (key -> !d(key))
                        case false => d + (key -> true)
                    case false => d
                })
                a
              },
              editor = editor,
              editorString = editor.getValue()
            ),
            Cmd.None
          )
