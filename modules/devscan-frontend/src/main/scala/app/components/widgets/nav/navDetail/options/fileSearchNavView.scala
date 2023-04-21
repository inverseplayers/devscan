package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import Css.*

object FileSearchNavView:

  val jsonView = ""

  val sample = "https://svelte.dev/tutorial/svelte-self"
  val sample2 = "https://jolly-sally.tistory.com/127"
  val sample3 = "https://www.baeldung.com/jackson-json-node-tree-model"
  val sample4 = "json2caseclass"
  val arrow = "△ ▽ ◁ ▷"
  val arrow2 = "▲ ▼ ◀ ▶"
  val arrow3 = "⟳ ⟲"

  def view(model: Model): Html[Msg] =
    div(`class` := s"$nav_detail")(
      div(
        gen.cell(
          Cell.NavDetail_Row("▶ㅤ" + TextGen.NavDetail.title),
          Cell.NavDetail_Row("▽ 대분류"),
          Cell.NavDetail_Row("ㅤ▽ 중분류"),
          Cell.NavDetail_Row("ㅤㅤ▶ 소분류")
          // Cell.NavDetail_Row("▷ src"),
          // Cell.NavDetail_Row("ㅤ▷ docs"),
          // Cell.NavDetail_Row("ㅤ▽ main"),
          // Cell.NavDetail_Row("ㅤㅤ▶ api"),
          // Cell.NavDetail_Row("ㅤㅤ▽ components"),
          // Cell.NavDetail_Row("ㅤㅤㅤ▽ pages"),
          // Cell.NavDetail_Row("ㅤㅤㅤㅤ PageView.scala"),
          // Cell.NavDetail_Row("▷ 구인"),
          // Cell.NavDetail_Row("ㅤ▷ frontend"),
          // Cell.NavDetail_Row("ㅤ▽ backend"),
          // Cell.NavDetail_Row("ㅤㅤ▶ js/ts"),
          // Cell.NavDetail_Row("ㅤㅤ▽ scala"),
          // Cell.NavDetail_Row("ㅤㅤㅤ▶ 크롤링"),
          // Cell.NavDetail_Row("ㅤㅤㅤ▶ 블록체인"),
          // Cell.NavDetail_Row("ㅤㅤㅤ▶ db"),
          // Cell.NavDetail_Row("ㅤㅤㅤ..."),
          // Cell.NavDetail_Row("▷ 구직"),
          // Cell.NavDetail_Row("ㅤ▷ frontend"),
          // Cell.NavDetail_Row("ㅤ▽ backend"),
          // Cell.NavDetail_Row("ㅤㅤ▶ js/ts"),
          // Cell.NavDetail_Row("ㅤㅤ▽ scala"),
          // Cell.NavDetail_Row("ㅤㅤㅤ▶ 크롤링"),
          // Cell.NavDetail_Row("ㅤㅤㅤ▶ 블록체인"),
          // Cell.NavDetail_Row("ㅤㅤㅤ▶ db"),
          // Cell.NavDetail_Row("ㅤㅤㅤ...1")
        )
      ),
      // div()
      JsonParser4.view(model)
      // div()()
    )
