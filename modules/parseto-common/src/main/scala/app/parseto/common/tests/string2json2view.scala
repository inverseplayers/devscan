package app.parseto.common.tests
import scala.util.chaining.*
import app.parseto.common.function.logs.log2
import app.parseto.common.parser.*
import app.parseto.common.function.logs.log
import app.parseto.common.data.JsonString.app

val string2json2view_example =
  app
    .pipe(string2json)
    // .pipe(json2string_foldable(List("app", "구인")))
    .pipe(json2string_foldable(List("app", "구인", "프론트엔드", "0", "이력서1")))
    .pipe(log2("string2json2view_example"))

val string2view_1 = string2string(raw"안녕하세요 \n 제이름은 \n ooo 입니다.")

val testChain =
  "안녕하세요 \n 제이름은 \n ooo 입니다."
    .tap(log)
    .pipe(log)

val lazy_log = () =>
  // string2json2view_example
  string2string("aas")
