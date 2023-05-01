// package app
// import tyrian.*
// import cats.effect.IO
// import tyrian.Html.*
// import Css.*

// object FileSearchNavView:

//   val jsonView = ""

//   val sample = "https://svelte.dev/tutorial/svelte-self"
//   val sample2 = "https://jolly-sally.tistory.com/127"
//   val sample3 = "https://www.baeldung.com/jackson-json-node-tree-model"
//   val sample4 = "json2caseclass"
//   val arrow = "△ ▽ ◁ ▷"
//   val arrow2 = "▲ ▼ ◀ ▶"
//   val arrow3 = "⟳ ⟲"

//   def view(model: Model): Html[Msg] =
//     div(
//       `class` := s"scroll-bar-area  $nav_detail ${model.isOver}"
//     )(
//       div(
//         gen.cell(
//           // Cell.NavDetail_Row("▶ㅤ" + TextGen.NavDetail.title),
//           // Cell.NavDetail_Row("▽ 대분류"),
//           // Cell.NavDetail_Row("ㅤ▽ 중분류"),
//           // Cell.NavDetail_Row("ㅤㅤ▶ 소분류")
//         )
//       ),
//       div(`class` := s"")(JsonParser.view(model)),
//       div(`class` := s"scroll-bar")()
//     )
