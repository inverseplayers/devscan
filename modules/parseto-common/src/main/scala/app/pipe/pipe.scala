package parseto.common.pipe

import scala.util.chaining.*
import parseto.common.data.*
import parseto.common.function.Log.*

object Pipe:
  val parseJsonString1 = JsonString.ex1
    .pipe(log)

  val parseJsonString2 = JsonString.ex2.pipe(log)
