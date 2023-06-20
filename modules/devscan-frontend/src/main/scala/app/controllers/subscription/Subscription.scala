package app
import tyrian.Html.*
import cats.effect.IO
import org.scalajs.dom.*
import tyrian.*
import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

// @js.native
// @JSGlobal("CodeMirror")
// object CodeMirror extends js.Object {
//   def apply(
//       element: js.Any,
//       options: js.Dictionary[js.Any]
//   ): CodeMirrorInstance = js.native
// }

// @js.native
// trait CodeMirrorInstance extends js.Object {
//   def getValue(): String = js.native
//   def setValue(value: String): Unit = js.native
// }

// import com.github.mcallisto.scalajs.Jsoup
// import org.jsoup.Jsoup
// import org.jsoup

// import org.scalajs.dom
// import scala.scalajs.js.annotation.JSExportTopLevel

// import org.scalajs.dom

// import com.github.mcallisto.scalajs.Jsoup

// import org.jsoup.nodes.{Document, Element}
import scala.util.chaining.*
import app.parseto.common._api.*

object Subscriptions:
  def subscriptions(model: Model): Sub[IO, Msg] =
    Sub.Batch(
      Option(document.querySelector(".dom-input")) match
        case None => Sub.None

        case Some(element) =>
          Sub.fromEvent[IO, KeyboardEvent, Msg](
            "keydown",
            element
          ) { e =>
            // (e.ctrlKey || e.metaKey) && e.key == "s" match
            //   case true =>
            //     e.preventDefault();
            //     Some(
            //       OnEffectMsg.On_KeyUp_Json(
            //         element
            //           .tap(e => log2("e.innerHTML")(e.innerHTML))
            //           .tap(e => log2("e.innerText")(e.innerText))
            //           .pipe(_.innerText)
            //       )
            //     )
            //   case _ => Some(OnEffectMsg.None)
            (e.ctrlKey || e.metaKey) && e.key == "s" match
              case true =>
                // val editorElement = document.querySelector(".dom-input")

                // val options = js.Dictionary[js.Any](
                //   "lineNumbers" -> true,
                //   "tabSize" -> 2,
                //   "mode" -> "javascript"
                //   // "theme" -> "monokai"
                // )
                // val editor = CodeMirror(editorElement, options)

                // // editor.setValue(
                // //   model.json.pipe(
                // //     json2string_foldable(model.current_jsonkey.tail)
                // //   )
                // // )
                log2("ddd")(model.editorString)
                Some(OnEffectMsg.On_KeyUp_Json(model.editorString))
              case _ => Some(OnEffectMsg.None)
          }
    )
