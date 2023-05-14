package app
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import org.scalajs.dom.document
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.ModelPipe.*
import io.circe.Json
import app.JsonParser.getObj
import app.JsonData.getJsonData
import scala.util.chaining.*
import io.circe.JsonObject
import io.circe.parser.decode

object DepthUpdate:
  def getJsonValue(json: Json, keys: List[String | Int]): String =
    keys.length match
      case 0 => json.toString
      case _ =>
        keys(0).toString() match
          case d: String if !d.forall(_.isDigit) =>
            getJsonValue(json.pipe(getObj)(d).get, keys.drop(1))
          case d: String if d.forall(_.isDigit) =>
            getJsonValue(
              {
                val a = json.fold(
                  "null",
                  _.toString,
                  _.toString,
                  _.toString,
                  arr => s"${arr(d.toInt)}",
                  obj => s"Object[${obj.size}]"
                )
                getJsonData(a)
              },
              keys.drop(1)
            )
  def update(model: Model): DepthMsg => (Model, Cmd[IO, Msg]) =
    case DepthMsg.OnClick(
          depth: Int,
          key: String,
          current_jsonkey: List[String | Int]
        ) =>
      depth match
        case _ =>
          (
            model.copy(
              current_jsonkey = current_jsonkey,
              current_jsonValue =
                getJsonValue(model.json, current_jsonkey.drop(1)),
              current_depth = s"$depth:$key",
              depth = {
                val a = model.depth.zipWithIndex.map((d, i) => {
                  depth == i match
                    // 키가 없으면 키를 true로 넣고, 키가 있으면 키값을 not 연산하여서 집어넣는다
                    case true =>
                      d.contains(key) match
                        case true  => d + (key -> !d(key))
                        case false => d + (key -> true)
                    case false => d
                })
                a
              }
            ),
            Cmd.None
          )
