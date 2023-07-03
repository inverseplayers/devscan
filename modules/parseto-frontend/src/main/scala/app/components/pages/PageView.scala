package parseto
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import scala.util.chaining.*

object PageView:

  case class BizSector(
      name: String,
      isClick: Boolean = false
  )

  val list = List(
    BizSector("요식업"),
    BizSector("요식업"),
    BizSector("요식업"),
    BizSector("요식업"),
    BizSector("요식업"),
    BizSector("요식업"),
    BizSector("요식업"),
    BizSector("요식업"),
    BizSector("요식업"),
    BizSector("요식업")
  )

  def genButton(d: BizSector) =
    button(`class` := "h-16 border border-gray-300 rounded-lg")(
      d.name
    )

  def view(model: Model): Html[Msg] =
    div(`class` := s"")(
      div(`class` := "relative bg-white h-14 items-center border-b flex")(
        div(`class` := "text-center w-full font-bold")("회원가입")
      ),
      div(`class` := "flex flex-col gap-4 p-8")(
        div(`class` := "text-lg font-bold")("어떤 업종을 운영하시나요?"),
        div(`class` := "grid grid-cols-3 gap-4 text-sm text-gray-600")(
          list.map(genButton)
        )
      ),
      button(
        `type` := "submit",
        `class` := "fixed bottom-0 left-0 w-full flex py-4 justify-center text-white font-medium bg-blue-600 text-white"
      )("다음")
    )
