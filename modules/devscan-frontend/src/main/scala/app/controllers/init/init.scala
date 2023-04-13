package app
import tyrian.*
import cats.effect.IO
import M.*

object Init:
  def init(flags: Map[String, String]): (Model, Cmd[IO, Msg]) =
    (Model(pointer = 1), Cmd.None)
