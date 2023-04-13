package app
import tyrian.*
import cats.effect.IO

import M.*
object Update:
  def update(model: Model): Msg => (Model, Cmd[IO, Msg]) =
    // msg => update
    case Msg.Increment => (model.copy(pointer = model.pointer + 1), Cmd.None)
    case Msg.Decrement => (model.copy(pointer = model.pointer - 1), Cmd.None)
