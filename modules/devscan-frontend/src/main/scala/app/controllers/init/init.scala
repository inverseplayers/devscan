package app
import tyrian.*
import cats.effect.IO

object Init:
  def init(flags: Map[String, String]): (Model, Cmd[IO, Msg]) =
    (
      Model(
        appStates = List(
          StateCase(
            pageCase = PageCase.Page_Finders(),
            number = 1
          )
        ),
        pointer = 1
      ),
      Cmd.None
    )
