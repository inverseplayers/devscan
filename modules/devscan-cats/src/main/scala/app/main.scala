package CatsApp

import cats.effect.{IO, IOApp, ExitCode}

object Main extends IOApp:
  override def run(args: List[String]): IO[ExitCode] =
    IO.println("Hello, World!").as(ExitCode.Success)
