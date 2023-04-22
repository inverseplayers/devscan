package app
import tyrian.*
import cats.effect.IO

object Update:
  def update(model: Model): Msg => (Model, Cmd[IO, Msg]) =
    // msg => update
    case inputMsg: PageMsg => PageUpdate.update(model)(inputMsg)
