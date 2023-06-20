package app
import tyrian.Html.*

import io.circe.Json
import tyrian.Html
// import parseto.common.parser.Parser.*
import app.parseto.common._api.*
// import app.parseto.common.parser.string2json

final case class Model(
    pointer: Int,
    appStates: List[StateCase],
    depth: List[Map[String, Boolean]] = List(
      Map("Depth_1" -> true),
      Map("Depth_2" -> true),
      Map("Depth_3" -> true),
      Map("Depth_4" -> true),
      Map("Depth_5" -> true),
      Map("Depth_6" -> true),
      Map("Depth_7" -> true),
      Map("Depth_8" -> true),
      Map("Depth_9" -> true),
      Map("Depth_10" -> true)
    ),
    json: Json = string2json(app),
    current_depth: String = "0:",
    current_jsonkey: List[String] = List("s"),
    current_jsonValue: String = "",
    isOver: Boolean = false,
    isMinimap: Boolean = false,
    dom: List[Html[Nothing]] = List(div(`class` := "pl-1")("a ")),
    map_dom: Map[String, List[Html[Nothing]]] = Map(
      List("s").toString() -> List(
        div(`class` := "pl-1")("a ")
      )
    ),
    editor: CodeMirrorInstance,
    editorString: String = ""
)
