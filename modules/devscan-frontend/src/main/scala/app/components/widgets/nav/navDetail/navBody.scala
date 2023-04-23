package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
// import css.*

object NavBodyView:
  def render(model: Model): Html[Msg] =
    // model.appStates()
    ModelPipe.find_current_PageCase(model) match
      case PageCase.Page_Finders(_) => FileSearchNavView.view(model)
      case PageCase.Page_Searchs(_) => div()

  def view(model: Model): Html[Msg] =
    NavBodyView.render(model)
