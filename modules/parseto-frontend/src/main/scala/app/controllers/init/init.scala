package parseto
import tyrian.*
import cats.effect.IO

object Init:
  def init(flags: Map[String, String]): (Model, Cmd[IO, Msg]) =
    (
      Model(
        pointer = 1
      ),
      Cmd.None
    )
