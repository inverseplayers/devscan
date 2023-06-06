package app.parseto.common.parser
import scala.util.matching.Regex

import tyrian.Html.*
import scala.util.chaining.*
import app.parseto.common.function.logs.log2
import app.parseto.common.function.logs.log

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
def splitInput(input: String): List[String] =
  input
    .pipe(log2("인풋"))
    .split(" ")
    .pipe(log2("인풋2"))
    .map { element =>
      val spacing = element.length match {
        case 0 => ""
        case _ => " " * element.length
      }
      spacing + element
    }
    .pipe(log2("인풋3"))
    .toList
    .pipe(log2("인풋4"))

def genLine(lines: List[String]) = lines.map(str => div(genSyntax(str)))
def genSyntax(line: String) =
  // "(?=\\s)|(?<=\\s)".r
  splitInput(line)
    // .split(line)
    // line
    // // .replaceAll(" ", raw" &nbsp; ")
    // .split("\\s+")
    .pipe(a => a)
    .toList
    .pipe(log2("뭐지?"))
    .map(s =>
      s match
        case "package" | "import" => span(style := "color: #569cd6;")(s"$s")
        case _                    => span(s"$s")
    )
