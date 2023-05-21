package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
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
    div(
      `class` := s"nav_detail $nav_detail ${model.isOver}"
    )(
      div(`class` := s"json-area")(JsonTree.view(model))
      // Minimap.view(model)
    )
