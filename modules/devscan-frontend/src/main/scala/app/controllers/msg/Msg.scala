package app

import io.circe.Json

sealed trait Msg

enum PageMsg extends Msg:
  case PreUpdate(page: PageCase) extends PageMsg
  // case GotoObserver(page: Int)   extends PageMsg
  // case BackObserver              extends PageMsg

  // // 데이터 업데이트
  // case DataUpdate(sub: PubCase) extends PageMsg
