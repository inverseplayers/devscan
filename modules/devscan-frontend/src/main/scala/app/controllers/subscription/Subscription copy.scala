// package app

// import cats.effect.IO
// import org.scalajs.dom.*
// import tyrian.*

// object Subscriptions:
//   def subscriptions(model: Model): Sub[IO, Msg] =
//     Sub.Batch(
//       Option(Dom.select("minimap-absolute")) match
//         case None => Sub.None

//         case Some(element) =>
//           Sub.None
//       ,
//       Option(Dom.select("minimap-window")) match
//         case None => Sub.None

//         case Some(element) =>
//           Sub.fromEvent[IO, MouseEvent, Msg](
//             "click",
//             element
//           ) { e =>
//             println("e")
//             println(e)
//             None
//             // e.keyCode match
//             //   case 13 =>
//             //     // Enter key
//             //     None
//             //   // Some("")
//             //   case _ =>
//             //     None
//           }
//       ,
//       Sub.fromEvent("resize", window) { e =>
//         println("e")
//         println(e)
//         print(e)
//         Some(PageMsg.PreUpdate(PageCase.Page_Searchs()))
//       }
//     )

// //     function getDimensions(){

// //     let size = {
// //         doc: { x: document.body.clientWidth , y: document.body.clientHeight },
// //         win: { x: window.innerWidth , y: window.innerHeight },
// //         mini_doc: { x: minimap.clientWidth  , y: minimap.clientHeight },
// //         mini_win : {x: 0, y: 0},
// //     }

// //     let gen_Ratio = (a,b) => a/b

// //     let winR = gen_Ratio(size.win.y,size.win.x)
// //     let docR = gen_Ratio(size.doc.y,size.doc.x)
// //     mini_scale = gen_Ratio(size.mini_doc.x,size.doc.x)

// //     mini_doc_size.style.marginTop = `${docR * 100}%`
// //     mini_win.style.paddingTop = `${winR * 100}%`;
// //     mini_doc.style.transform = `scale(${mini_scale})`;
// //     mini_doc.style.width = `${(100 / mini_scale)}%`
// //     mini_doc.style.height = `${(100 / mini_scale)}%`
// // }
