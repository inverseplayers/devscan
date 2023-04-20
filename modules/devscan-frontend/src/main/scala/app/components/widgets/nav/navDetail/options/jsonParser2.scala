// // package app

// // import com.fasterxml.jackson.databind.ObjectMapper
// // import collection.JavaConverters.asScalaIteratorConverter
// // // import jdk.CollectionConverters.IteratorHasAsScala
// // // import io.github.nremond.SecureSseJackson._
// // // import io.github.nremond.SecureSseJackson.defaultFormats
// // // import org.tyrian.json._
// // // import org
// // // import collection.JavaConverters.asScalaIteratorConverter

// import com.fasterxml.jackson.databind.ObjectMapper
// // // import com.fasterxml.jackson.databind.node.JsonNodeType

// sealed trait JsonValue
// case class JsonString(value: String) extends JsonValue
// case class JsonNumber(value: Double) extends JsonValue
// case class JsonBoolean(value: Boolean) extends JsonValue
// case class JsonObject(value: List[JsonNode]) extends JsonValue

// case class JsonNode(key: String, value: JsonValue)

// object J:
//   import com.fasterxml.jackson.databind.ObjectMapper

//   def parseJson(jsonString: String): JsonNode = {
//     val mapper = new ObjectMapper()
//     val json = mapper.readTree(jsonString)
//     val fields = json.fields().asScala.toList
//     val values = fields.map { case (key, node) =>
//       node.getNodeType match {
//         case JsonNodeType.STRING  => JsonString(node.asText())
//         case JsonNodeType.NUMBER  => JsonNumber(node.asDouble())
//         case JsonNodeType.BOOLEAN => JsonBoolean(node.asBoolean())
//         case JsonNodeType.OBJECT => JsonObject(List(parseJson(node.toString())))
//         case _ =>
//           throw new RuntimeException(
//             s"Unsupported JSON node type: \${node.getNodeType}"
//           )
//       }
//     }
//     JsonNode(
//       "",
//       JsonObject(fields.zip(values).map { case ((key, _), value) =>
//         JsonNode(key, value)
//       })
//     )
//   }
// //   import org.tyrian.json._
// //   import scala.xml.Node

// //   def renderNode(node: JsonNode): Node = node match {
// //     case JsonNode(key, JsonString(value)) =>
// //       <div><b>{key}</b> : <span>{value}</span></div>
// //     case JsonNode(key, JsonNumber(value)) =>
// //       <div><b>{key}</b> : <span>{value.toString}</span></div>
// //     case JsonNode(key, JsonBoolean(value)) =>
// //       <div><b>{key}</b> : <span>{value.toString}</span></div>
// //     case JsonNode(key, JsonObject(value)) =>
// //       <div>
// //         <b>{key}</b> : <span onclick="toggleNode(this)">{
// //         s"Object[\${value.length}]"
// //       }</span>
// //         <div style="margin-left: 14px; display: none;">
// //             {value.map(renderNode)}
// //         </div>
// //         </div>
// //   }

// //   def renderHtml(jsonString: String): Node = {
// //     val json = parseJson(jsonString)
// //     <div>{renderNode(json)}</div>
// //   }
