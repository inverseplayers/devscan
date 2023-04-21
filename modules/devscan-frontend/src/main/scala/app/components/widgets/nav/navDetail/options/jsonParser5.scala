package app
import io.circe.parser._
import io.circe.generic.auto._
import tyrian.Html
import tyrian.Html._
import io.circe.Json
import app.M.Model

object JsonParser5:
  case class MyObject(key: String, value: String)

  // JSON string to parse
  val jsonString = """{"obj1":"2122","obj2":"123"}"""

  // Parse the JSON string
  val json = parse(jsonString).getOrElse(Json.Null)

  // Convert the Json instance to a Scala Map
  val map = json.as[Map[String, String]].getOrElse(Map.empty)

  // Define the HTML template for displaying the keys and values
  val template: MyObject => Html[Msg] = (d) =>
    div(
      `class` := "text-white"
      // span(
      //   onClick { obj =>
      //     obj.copy(value =
      //       if (obj.value == "0") obj.value.length.toString else "0"
      //     )
      //   },
      //   textContent { obj => obj.value }
      // ),
      // ifTrue { obj => obj.value != "0" }(
      //   entries(map).map { case (key, value) =>
      //     self(MyObject(key, value))
      //   }
      // )
    )(div(d.key), div(d.value))

  // Render the HTML template with the initial object state
  val initialObject = MyObject("JSON", "0")
  def view(model: Model): Html[Msg] = template(initialObject)
