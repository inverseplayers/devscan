package app

import cats.effect.IO
import org.scalajs.dom.*
import tyrian.*

object Subscriptions:
  def subscriptions(model: Model): Sub[IO, Msg] =
    Sub.Batch(
      Option(Dom.select("dom-input")) match
        case None => Sub.None

        case Some(element) =>
          Sub.fromEvent[IO, KeyboardEvent, Msg](
            "keydown",
            element
          ) { e =>
            (e.ctrlKey || e.metaKey) && e.key == "s" match
              case true =>
                e.preventDefault();
                Some(OnEffectMsg.On_KeyUp_Json(""))
              case _ => Some(OnEffectMsg.None)
          }
    )
