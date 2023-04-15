package app

object CssCase:
  enum Target(val value: String):
    case T_Text extends Target("text")
    case T_Bg extends Target("bg")
    case T_Border extends Target("border")

  enum Color(val value: String):
    case Color_Gray extends Color("gray")
    case Color_Orange extends Color("orange")
    case Color_Slate extends Color("slate")

  enum Point(val value: Int):
    case Point_P50 extends Point(50)
    case Point_P100 extends Point(100)
    case Point_P200 extends Point(200)
    case Point_P300 extends Point(300)
    case Point_P400 extends Point(400)
    case Point_P500 extends Point(500)

  object Target:
    import CssCase.*
    val _Text = Target.T_Text
    val _Bg = Target.T_Bg
    val _Border = Target.T_Border

  object Color:
    import CssCase.*
    val _Gray = Color.Color_Gray
    val _Orange = Color.Color_Orange
    val _Slate = Color.Color_Slate

  object Point:
    import CssCase.*
    val _50 = Point.Point_P50
    val _100 = Point.Point_P100
    val _200 = Point.Point_P200
    val _300 = Point.Point_P300
    val _400 = Point.Point_P400
    val _500 = Point.Point_P500

  case class Tailwind(t: Target, c: Color, p: Point)

  def genCss(css: Tailwind): String =
    s" ${css.t.value}-${css.c.value}-${css.p.value}"
