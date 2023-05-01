package app

import io.circe.parser.decode
import io.circe.{Json, JsonObject}

object JsonData:
//   final case class JsonData(json: String, key: String)
  val jsonString =
    """{
       "frontend1": 1,"frontend1": 1, "backend1": ["js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs","js","ts","rxjs"], "fronatend": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend2": 1,"frontend2": 1, "backend2": ["js","ts","rxjs"], "fronsdtend": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend3": 1,"frontend3": 1, "backend3": ["js","ts","rxjs"], "frontednd": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend13": 1,"fronten4d": 1, "backend3": ["js","ts","rxjs"], "frontasdend": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend23": 1,"frofnten2d": 1, "backend3": ["js","ts","rxjs"], "frontenda": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend33": 1,"fronsten2d": 1, "backend3": ["js","ts","rxjs"], "frontednd": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend33": 1,"fronte2n2d": 1, "backend3": ["js","ts","rxjs"], "frontednd": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend43": 1,"fronten3d": 1, "backend3": ["js","ts","rxjs"], "frontefnd": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend53": 1,"frontaen4d": 1, "backend3": ["js","ts","rxjs"], "frontenqwd": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend53": 1,"fronten4d": 1, "backend3": ["js","ts","rxjs"], "frontenqwd": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1},
       "frontend14": 1,"fronten5d": 1, "backend4": ["js","ts","rxjs"], "frontende": 19,"designer": {"d": "A", "e": "B"}, "marketer": "null", "g": {"h": [6,7,8], "i": 9,"frontend": 1}
    }"""

  def getJsonData(jsonString: String) =
    decode[Json](jsonString) match {
      case Left(error) => {
        Json.True
      }
      case Right(data) => data
    }
