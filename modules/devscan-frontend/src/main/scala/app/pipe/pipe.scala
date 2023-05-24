package app
import scala.util.chaining.*
import app.parseto.common._api.*

def json2dom(model: Model) = model.json
  // json select
  .pipe(json2string_foldable(model.current_jsonkey.tail))
  // 따옴표 제거
  .pipe(string2string)

// 줄바꿈 => 리스트로 쪼개기
  .pipe(string2List)
  .pipe(listString2dom)
