// final def fold[X](
//     jsonNull: => X,
//     jsonBoolean: Boolean => X,
//     jsonNumber: JsonNumber => X,
//     jsonString: String => X,
//     jsonArray: Vector[Json] => X,
//     jsonObject: JsonObject => X
// ): X

// json.hcursor
//   .downField(s)
//   .withFocus(
//     _.fold(
//       "null",
//       _.toString,
//       _.toString,
//       _.toString,
//       arr => s"Array[${arr.length}]",
//       obj => s"Object[${obj.size}]"
//     )
//       .pipe(string2json)
//   )
//   .top
//   .get
