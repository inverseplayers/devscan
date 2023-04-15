package app

object _css:
  val test_bg = "bg-[rgba(120,20,20,0.15)]"

object Css:
  import _css.*

  val main = "h-screen w-screen flex"
  val page = "h-screen w-screen flex bg-[rgba(15,15,15,0.95)]"
  val nav_container = "h-screen w-[300px] flex  bg-[rgba(20,20,20,0.95)]"
  val nav_detail = s"h-screen w-[300px] bg-[rgba(20,20,20,0.15)] "
  // + s"$test_bg"
  val navs =
    "h-screen w-[65px] bg-[rgba(20,20,20,0.88)] text-[rgb(255,255,255)] pt-[10px]"
  val button_container = "w-full h-[55px] flex justify-center "
  val button_sub = "text-black"
  val icon = "material-symbols-outlined"

  enum Target:
    case text extends Target
    case bg extends Target
  // enum Color:
  //   case gray extends Color
  //   case orange extends Color
  // enum ColorNum:
  //   case _100 extends ColorNum
  //   case _200 extends ColorNum

  // def genColor(target: Target, color: Color, num: ColorNum) =
  //   s"${target}-${color}-${num}"

  // trait Target:

  object text:

    val white = "text-white"
    def gray(num: Int) = s"text-gray-$num"
    val black = "text-black"

  object bg:

    val white = "text-white"
    def gray(num: Int) = s"text-gray-$num"
    val black = "text-black"

// object CCC:
//   // case class Targets(target: Target = Target.text)

//   // val a = new Targets().target
// // css().text().gray()._100
//   val todo = "CCC().text().gray()._100"
//   case class ccc(text: String = "text", bg: String = "bg")
//   val cc = ccc()

//   val x = cc.bg
