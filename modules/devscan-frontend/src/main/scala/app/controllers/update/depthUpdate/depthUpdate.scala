package app
import tyrian.Html.*
import scala.scalajs.js
import org.scalajs.dom.window
import org.scalajs.dom.document
import scala.util.chaining.*
import tyrian.*
import cats.effect.IO
import app.ModelPipe.*

object DepthUpdate:
  def update(model: Model): DepthMsg => (Model, Cmd[IO, Msg]) =
    case DepthMsg.OnClick(depth: Int, key: String) =>
      // println(Dom.select("json-area").clientHeight)
      // println(document.body.clientHeight)
      println("model.depth")
      println(model.depth)
      println(s"depth : key")
      println(s"$depth : $key")
      println(model.current_depth)

      depth match
        case _ =>
          (
            model.copy(
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
