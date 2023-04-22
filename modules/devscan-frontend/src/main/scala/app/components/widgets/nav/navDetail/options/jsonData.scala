package app

import io.circe.parser.decode
import io.circe.{Json, JsonObject}

object JsonData:
//   final case class JsonData(json: String, key: String)
  val jsonString =
    """{
       "a": 1, "b": [2,3,4,5], "c": {"d": "A", "e": "B"}, "f": "Hello", "g": {"h": [6,7,8], "i": 9}
    }"""

  def getJsonData(jsonString: String) =
    decode[Json](jsonString) match {
      case Left(error) => {
        Json.True
      }
      case Right(data) => data
    }
