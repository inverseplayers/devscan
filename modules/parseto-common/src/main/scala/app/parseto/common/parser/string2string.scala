package app.parseto.common.parser
import tyrian.Html.*

def string2string(s: String) = s
  // .replaceAll(raw"""\\\"""", raw"") // " \"안녕\"  " => " 안녕  "
  .replaceAll(raw"""\"""", raw"") // " "안녕"  " => " 안녕 "

def string2List(s: String) =
  s.split(raw"\\n").toList

def listString2dom(s: List[String]) =
  s.map(d => {
    div(
      style := """color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, "Courier New", monospace; font-size: 11px; line-height: 17px;"""
    )(d)
  })

def listToHtml(l: List[String]) =
  List(
    div(
      style := """color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, "Courier New", monospace; font-size: 11px; line-height: 17px;"""
    )(
      div(
        style := "line-height: 17px;"
      )(
        genLine(l)
      )
    )
  )

def genLine(lines: List[String]) = lines.map(str => div(genSyntax(str)))
def genSyntax(line: String) = line
  .split(raw" ")
  .toList
  .map(s =>
    s match
      case "package" | "import" => span(style := "color: #569cd6;")(s" $s")
      case _                    => span(s" $s")
  )
