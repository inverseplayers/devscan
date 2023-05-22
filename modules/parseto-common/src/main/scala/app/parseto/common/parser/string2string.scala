package app.parseto.common.parser
import tyrian.Html.*

def string2string(s: String) = s
  .replaceAll(raw"""\\\"""", raw"") // " \"안녕\"  " => " 안녕  "
  .replaceAll(raw"""\"""", raw"") // " "안녕"  " => " 안녕 "
  .split(raw"\\n")
  .toList
  .map(d => {
    div(`class` := "pl-1")(d)
  })
