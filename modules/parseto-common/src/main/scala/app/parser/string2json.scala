package parseto.common.parser
import io.circe.parser.decode
import io.circe.{Json, JsonObject}

object Parser:
  def string2json(jsonString: String) =
    decode[Json](jsonString) match {
      case Left(error) => {
        Json.True
      }
      case Right(data) => data
    }
