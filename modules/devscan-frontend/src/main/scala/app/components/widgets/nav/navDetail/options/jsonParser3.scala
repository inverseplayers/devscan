// package app
// import tyrian.*
// import cats.effect.IO
// import tyrian.Html.*
// import io.circe.parser.decode
// import io.circe.{Json, JsonObject}

// final case class JsonData(json: String, key: String)

// object JsonData {
//   // def fromJson(json: String): Either[Throwable, JsonData] =
//   //   decode[JsonData](json)
// }
// object AA:
//   val jsonData = JsonData("", "")

//   val json: Json = decode[Json](
//     jsonData.json
//   ).getOrElse(Json.Null)
//   val obj: JsonObject = json.asObject.getOrElse(JsonObject.empty)
//   val entries: List[(String, Json)] = obj.toList
//   val objType: String =
//     obj.values.headOption.map(_.getClass.getSimpleName).getOrElse("Unknown")
//   val value: String = objType match {
//     case "JsonArray"  => s"Array[${entries.length}]"
//     case "JsonObject" => s"Object[${entries.length}]"
//     case _            => jsonData.json
//   }
