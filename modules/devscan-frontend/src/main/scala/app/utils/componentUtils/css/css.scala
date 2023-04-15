package app

object css:
  val _gray = "[rgba(50,50,50,1)]"
  val main = "h-screen w-screen flex"
  val page = "h-screen w-screen flex bg-[rgba(15,15,15,0.95)]"
  val nav_container = "h-screen w-[300px] flex  bg-[rgba(20,20,20,0.95)]"
  val nav_detail = "h-screen w-[300px] bg-[rgba(20,20,20,0.15)]"
  val navs =
    "h-screen w-[50px] bg-[rgba(20,20,20,0.88)] text-[rgb(255,255,255)] pt-[10px]"
  val button_container = "w-full h-[50px] flex justify-center "
  val button_sub = "text-black"
  val icon = "material-symbols-outlined"

  object text:
    val gray = s"text-$_gray"
    val white = "text-white"
    val black = "text-black"
