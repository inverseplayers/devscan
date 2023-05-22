package app.parseto.common.parser
import tyrian.Html.*

def string2string(s: String) = s
  .replaceAll(raw"""\\\"""", raw"") // " \"안녕\"  " => " 안녕  "
  .replaceAll(raw"""\"""", raw"") // " "안녕"  " => " 안녕 "

def string2List(s: String) =
  s.split(raw"\\n").toList

def listString2dom(s: List[String]) =
  s.map(d => {
    pre(`class` := "pl-1")(d)
  })
