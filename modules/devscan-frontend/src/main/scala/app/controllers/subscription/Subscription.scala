package app
import tyrian.Html.*
import cats.effect.IO
import org.scalajs.dom.*
import tyrian.*
// import com.github.mcallisto.scalajs.Jsoup
// import org.jsoup.Jsoup
// import org.jsoup

// import org.scalajs.dom
// import scala.scalajs.js.annotation.JSExportTopLevel

// import org.scalajs.dom

// import com.github.mcallisto.scalajs.Jsoup

// import org.jsoup.nodes.{Document, Element}
import scala.util.chaining.*
import app.parseto.common._api.*

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
            // val pattern = """(?<=<div.*?>).*?(?=<\/div>)""".r

            val _element2 = log2("element.innerHTML")(element.innerHTML)
            val _element = log2("element.innerText")(element.innerText)
            // element.oncopy.getClass("text/plain")
            //   pattern
            //     .findAllIn(element.outerHTML)
            //     .toList
            //     .mkString("\n")
            //     .replaceAll("<br>", "\n")

            // println("element")
            // println(element.innerHTML)
            // println(element.outerHTML.replaceAll("<[^>]*>", ""))
            (e.ctrlKey || e.metaKey) && e.key == "s" match
              case true =>
                // element.innerHTML = ""
                // element.innerHTML = _element
                //   .replaceAll(raw"""\\\"""", raw"")
                //   .replaceAll(raw"""\"""", raw"")
                //   .split(raw"\\n")
                //   .toList
                //   .map(d => {
                //     div(`class` := "pl-1")(d)
                //   })
                //   .toString()
                e.preventDefault();
                Some(
                  OnEffectMsg.On_KeyUp_Json(
                    log2("element.innerHTML")(_element)
                  )
                )
              case _ => Some(OnEffectMsg.None)
          }
    )
