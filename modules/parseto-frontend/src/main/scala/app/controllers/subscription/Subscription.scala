package parseto
import tyrian.Html.*
// import cats.effect.IO
// import org.scalajs.dom.*
import tyrian.*
import cats.effect.IO
// import scala.util.chaining.*

object Subscriptions:
  def subscriptions(model: Model): Sub[IO, Msg] =
    Sub.None
      // Sub.Batch(
      //   Option(Dom.select("dom-input")) match
      //     case None => Sub.None

      //     case Some(element) =>
      //       Sub.fromEvent[IO, KeyboardEvent, Msg](
      //         "keydown",
      //         element
      //       ) { e =>
      //         val _element = element.innerHTML
      //         (e.ctrlKey || e.metaKey) && e.key == "s" match
      //           case true =>
      //             e.preventDefault();
      //             Some(
      //               OnEffectMsg.On_KeyUp_Json(
      //                 _element
      //               )
      //             )
      //           case _ => Some(OnEffectMsg.None)
      //       }
      // )
