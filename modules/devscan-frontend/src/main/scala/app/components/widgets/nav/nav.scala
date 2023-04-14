package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import css.*

object NavView:

  def view(model: Model): Html[Msg] =
    div(`class` := s"$nav_container")(
      nav(`class` := s"$navs")(
        div(
          `class` := s"$button_container"
        )(
          button(
            `class` := s"$button_sub"
          )(
            span(
              `class` := s"$icon" + s" $white"
            )("content_copy")
          )
        ),
        div(
          `class` := s"$button_container"
        )(
          button(
            `class` := s"$button_sub"
          )(
            span(
              `class` := s"$icon"
            )("search")
          )
        )
      ),
      NavDetailView.view(model)
    )

    //   div(id := "title", onClick()))(
    //     span(id := "head")(img(id := "head-logo"))
    //   ),
    //   div(
    //     id := "buttons"
    //   )(
    //     button(
    //       `class` := s"${PageCase.Observer().name == find_name(model)}",
    //       onClick(PageMsg.PreUpdate(PageCase.Observer()))
    //     )(span()(PageCase.Observer().name))
    //   ),
