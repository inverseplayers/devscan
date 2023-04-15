package app
enum Color2(val rgb: Int):
  case Red extends Color2(0xff0000)
  case Green extends Color2(0x00ff00)
  case Blue extends Color2(0x0000ff)

enum Point(val point: Int):
  case I100 extends Point(100)
  case I200 extends Point(200)

case class Points(val I100: Point = Point.I100, val I200: Point = Point.I200)

enum Color(val point: Points):
  case Gray extends Color(new Points)

enum Target(val color: String):
  case Text extends Target("text")
//   case Orange extends Color(200)
// //   case Gray extends Color(Point(I100))
// //   case Orange extends Color(0x00ff00)

// enum Csss(val Color: Color):
//   case I100 extends Csss(100)
//   case I200 extends Csss(200)
//   case Text extends Csss(Color(100))
//   case Bg extends Csss(0x00ff00)

object C:
  // C.TEXT.GRAY.I100 == "text-gray-100"

  val sample1 = "text-gray-100"
  val sample2 = "bg-gray-100"
  val sample3 = Color.Gray.point.I100
//   val s = Csss.Blue.Rgb.toString()

//   case class Target(text: String)
//   case class color()
//   case class num()

//   enum Target:
//     case "text" :
//     case "bg"
//   type Color = "gray" | "orange"

//   def gen(target: Target ,color: ,num) =
