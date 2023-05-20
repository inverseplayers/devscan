package app

import io.circe.Json
import org.scalajs.dom.Element

sealed trait Msg

enum PageMsg extends Msg:
  case PreUpdate(page: PageCase) extends PageMsg
  // case GotoObserver(page: Int)   extends PageMsg
  // case BackObserver              extends PageMsg

  // // 데이터 업데이트
  // case DataUpdate(sub: PubCase) extends PageMsg

enum DepthMsg extends Msg:
  case OnClick(depth: Int, key: String, current_jsonkey: List[String])
      extends DepthMsg

enum OnEffectMsg extends Msg:
  case OnMouseOver(isOver: Boolean) extends OnEffectMsg
  case OnMouseOut(isOver: Boolean) extends OnEffectMsg
  case On_MiniMap_Click(e: Element) extends OnEffectMsg
  case On_MiniMap_ClickAfterUpdate(e: Element) extends OnEffectMsg
  case On_KeyUp_Json(e: String) extends OnEffectMsg
  case None extends OnEffectMsg
