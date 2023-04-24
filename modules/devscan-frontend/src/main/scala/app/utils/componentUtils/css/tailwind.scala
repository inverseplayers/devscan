package app

object CssCase:
  enum Action(val value: String):
    case A_Hover extends Action("hover:")
    case A_Focus extends Action("focus:")
    case A_Active extends Action("active:")
    case A_None extends Action("")

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
    case Point_P600 extends Point(600)
    case Point_P700 extends Point(700)
    case Point_P800 extends Point(800)
    case Point_P900 extends Point(900)

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
    val _600 = Point.Point_P600
    val _700 = Point.Point_P700
    val _800 = Point.Point_P800
    val _900 = Point.Point_P900
  object Action:
    import CssCase.*
    val _Active = Action.A_Active
    val _Focus = Action.A_Focus
    val _Hover = Action.A_Hover
    val _None = Action.A_None

  case class Tailwind(
      t: Target,
      c: Color,
      p: Point,
      a: Action = Action.A_None
  )

  def genCss(css: Tailwind*): String =
    css
      .map(css =>
        s" ${css.a.value}${css.t.value}-${css.c.value}-${css.p.value} "
      )
      .reduce((a, b) => a + b)
