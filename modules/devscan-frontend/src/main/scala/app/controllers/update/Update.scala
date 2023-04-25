package app
import tyrian.*
import cats.effect.IO

object Update:
  def update(model: Model): Msg => (Model, Cmd[IO, Msg]) =
    // msg => update
    case pageMsg: PageMsg   => PageUpdate.update(model)(pageMsg)
    case depthMsg: DepthMsg => DepthUpdate.update(model)(depthMsg)
    case e: OnEffectMsg     => OnEffectUpdate.update(model)(e)
