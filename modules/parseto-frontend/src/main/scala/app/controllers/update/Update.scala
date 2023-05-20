package parseto
import tyrian.*
import cats.effect.IO

object Update:
  def update(model: Model): Msg => (Model, Cmd[IO, Msg]) =
    // msg => update
    case pageMsg: PageMsg => PageUpdate.update(model)(pageMsg)
