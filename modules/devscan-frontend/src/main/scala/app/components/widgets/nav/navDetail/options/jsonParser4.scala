// package app
// import tyrian.*
// import cats.effect.IO
// import tyrian.Html.*
// import M.*
// import Css.*

// import io.circe.parser.decode
// import io.circe.{Json, JsonObject}

// final case class JsonData(json: String, key: String)

// object JsonParser4:
//   val jsonData = JsonData(
//     """{
// 	a: 1, b: [2,3,4,5], c: {d: 'A', e: 'B'}, f: 'Hello', g: {h: [6,7,8], i: 9}
// }""",
//     ""
//   )

//   val json: Json = decode[Json](jsonData.json) match {
//     case Left(error) => Json.Null
//     case Right(data) => data
//   }

//   val obj: JsonObject = json.asObject.getOrElse(JsonObject.empty)

//   val entries: List[(String, Json)] = obj.toIterable.toList

//   val objType: String = json
//     .fold(
//       Json.Null,
//       _ => "JsonBoolean",
//       _ => "JsonNumber",
//       _ => "String",
//       _ => "JsonArray",
//       _ => "JsonObject"
//     )
//     .getClass
//     .getSimpleName

//   val value: String = json.fold(
//     "null",
//     _.toString,
//     _.toString,
//     _.toString,
//     arr => s"Array[${arr.length}]",
//     obj => s"Array[${obj.size}]"
//   )
//   def view(model: Model): Html[Msg] = div()(
//     "ㅇㅏㄴ녀ㅇ?"
//   )
