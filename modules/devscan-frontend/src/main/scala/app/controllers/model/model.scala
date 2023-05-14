package app

import io.circe.Json
import app.JsonData.jsonString
import app.JsonData.getJsonData

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
    json: Json = getJsonData(jsonString),
    current_depth: String = "0:",
    current_jsonkey: List[String | Int] = List(),
    current_jsonValue: String = "",
    isOver: Boolean = false,
    isMinimap: Boolean = false
)
