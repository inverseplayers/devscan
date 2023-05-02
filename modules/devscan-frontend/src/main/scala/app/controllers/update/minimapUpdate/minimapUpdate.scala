// package app
// import tyrian.Html.*
// import scala.scalajs.js
// import org.scalajs.dom.window
// import org.scalajs.dom.document
// import scala.util.chaining.*
// import tyrian.*
// import cats.effect.IO
// import app.ModelPipe.*

// object MinimapUpdate:
//   def update(model: Model): DepthMsg => (Model, Cmd[IO, Msg]) =
//     case DepthMsg.OnClick(depth: Int, key: String) =>
//       println(Dom.select("json-area").clientHeight)
//       println(document.body.clientHeight)

//       depth match
//         case _ =>
//           (
//             model.copy(
//             ),
//             Cmd.None
//           )
