// package app.controllers

// import cats.effect.IO
// import org.scalajs.dom.*
// import tyrian.*

// // object Subscriptions:
// //   def subscriptions(model: Model): Sub[IO, Msg] =
// //     Sub.Batch(
// //       Option(Dom.select("dom")) match
// //         case None => Sub.None

// //         case Some(element) =>
// //           Sub.fromEvent[IO, KeyboardEvent, Msg](
// //             "keydown",
// //             element
// //           ) { e =>
// //             e.keyCode match
// //               case 13 =>
// //                 // Enter key
// //                 None
// //               // Some("")
// //               case _ =>
// //                 None
// //           }
// //       ,
// //       Sub.fromEvent("popstate", window) { e =>
// //         val state = e.asInstanceOf[PopStateEvent].state
// //       }
// //     )
