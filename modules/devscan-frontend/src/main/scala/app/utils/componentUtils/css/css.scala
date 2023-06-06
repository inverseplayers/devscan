package app

object _css:
  val test_bg = "bg-[rgba(120,20,20,0.15)]"

object Css:
  import _css.*

  val main = "h-screen w-screen flex"
  val page = "h-screen flex bg-[rgba(15,15,15,0.95)] overflow-auto	"
  val nav_container = "h-screen flex  bg-[rgba(20,20,20,0.95)]"
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

  object text:

    val white = "text-white"
    def gray(num: Int) = s"text-gray-$num"
    val black = "text-black"

  object bg:

    val white = "text-white"
    def gray(num: Int) = s"text-gray-$num"
    val black = "text-black"
