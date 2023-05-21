package parseto.common.logs

import parseto.common.function.Log.log2

object Logs:
  val json2string_when_key_is_digit: (String) => String = log2[String](
    "json2string_when_key_is_digit"
  )
