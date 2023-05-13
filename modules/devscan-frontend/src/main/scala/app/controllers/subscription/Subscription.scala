package app

import cats.effect.IO
import org.scalajs.dom.*
import tyrian.*

object Subscriptions:
  def subscriptions(model: Model): Sub[IO, Msg] =
    Sub.Batch(
      // Option(Dom.select("minimap-absolute")) match
      //   case None => Sub.None

      //   case Some(element) =>
      //     Sub.None
      // ,
      // Option(Dom.select("navBody")) match
      //   case None => Sub.None

      //   case Some(element) =>
      //     println("dkdk")
      //     //   Sub.fromEvent[IO, MouseEvent, Msg](
      //     Sub.fromEvent(
      //       "mouseup",
      //       element
      //     ) { e =>
      //       println("e")
      //       println(e)

      //       Some(OnEffectMsg.On_MiniMap_Click(element))
      //     }
      // ,
      // Sub.fromEvent("resize", window) { e =>
      //   println("e")
      //   println(e)
      //   print(e)
      //   Some(PageMsg.PreUpdate(PageCase.Page_Searchs()))
      // }
    )
