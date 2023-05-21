package app.parseto.common.tests.logs
import app.parseto.common.function.logs.*

object Logs:
  val json2string_when_key_is_digit: (String) => String = log2[String](
    "json2string_when_key_is_digit"
  )
