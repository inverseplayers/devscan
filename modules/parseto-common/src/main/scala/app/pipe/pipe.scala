package parseto.common.pipe

import scala.util.chaining.*
import parseto.common.data.*
import parseto.common.function.Log.*
import parseto.common.parser.Parser.*

object Pipe:
  def parseJsonString1 = JsonString.ex1
    .pipe(log2("ex1"))
    .pipe(string2json)

  def parseJsonString2 = JsonString.ex2.pipe(log)
