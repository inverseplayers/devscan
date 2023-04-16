package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import Css.*

object FileSearchNavView:
  val arrow = "△ ▽ ◁ ▷"
  val arrow2 = "▲ ▼ ◀ ▶"
  val arrow3 = "⟳ ⟲"

  def view(model: Model): Html[Msg] =
    div(`class` := s"$nav_detail")(
      gen.cell(
        Cell.NavDetail_Row("ㅤ" + TextGen.NavDetail.title),
        Cell.NavDetail_Row("▽ 대분류"),
        Cell.NavDetail_Row("ㅤ▽ 중분류"),
        Cell.NavDetail_Row("ㅤㅤ▶ 소분류"),
        Cell.NavDetail_Row("▷ src"),
        Cell.NavDetail_Row("ㅤ▷ docs"),
        Cell.NavDetail_Row("ㅤ▽ main"),
        Cell.NavDetail_Row("ㅤㅤ▶ api"),
        Cell.NavDetail_Row("ㅤㅤ▽ components"),
        Cell.NavDetail_Row("ㅤㅤㅤ▽ pages"),
        Cell.NavDetail_Row("ㅤㅤㅤㅤ PageView.scala")
      )
    )
