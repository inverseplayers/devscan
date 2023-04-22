package app

import io.circe.parser.decode
import io.circe.{Json, JsonObject}

object JsonData:
//   final case class JsonData(json: String, key: String)
  val jsonString =
    """{
       "frontend": 1, "backend": ["js","ts","rxjs"], "designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9}
    }"""

  def getJsonData(jsonString: String) =
    decode[Json](jsonString) match {
      case Left(error) => {
        Json.True
      }
      case Right(data) => data
    }
