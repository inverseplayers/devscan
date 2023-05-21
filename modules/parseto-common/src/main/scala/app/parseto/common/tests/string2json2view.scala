package app.parseto.common.tests

import app.parseto.common.data.JsonString
import app.parseto.common._api.*

val string2json2view_example =
  app
    .pipe(string2json)
    .pipe(json2string_foldable(List("app", "구인")))
    .pipe(log2("string2json2view_example"))

val lazy_log = () => string2json2view_example
