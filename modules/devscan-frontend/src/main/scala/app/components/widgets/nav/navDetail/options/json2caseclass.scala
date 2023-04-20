// package app

// object Json2CaseClass:
//   val a = """
//         {
//         "a": 1,
//         "b": [2,3,4,5],
//         "c": {"d": "A", "e": "B"},
//         "f": "Hello",
//         "g": {"h": [6,7,8], "i": 9}
//         }"""

//   case class C(
//       d: String,
//       e: String
//   )

//   case class G(
//       h: Seq[Int],
//       i: Int
//   )

//   case class RootInterface(
//       a: Int,
//       b: Seq[Int],
//       c: C,
//       f: String,
//       g: G
//   )

// //   import scala.util.parsing.json.JSON

// //   val json =
// //     "{\"name\":\"Sammy\",\"email\":\"sammy@example.com\",\"plan\":\"Pro\"}"
// //     val obj = JSON.parseFull(json).get.asInstanceOf[Map[String, Any]]
// //     var expanded = false
// //     val entries = obj.toSeq
// //     val t = obj.getClass.getSimpleName
// //     val value = t match {
// //       case "Map"  => s"Object[{entries.length}]"
// //       case "List" => s"Array[{entries.length}]"
// //       case _      => json
// //     }
