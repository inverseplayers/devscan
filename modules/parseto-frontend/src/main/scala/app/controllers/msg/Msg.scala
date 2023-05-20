package parseto

import io.circe.Json
import org.scalajs.dom.Element

sealed trait Msg

enum PageMsg extends Msg:
  case PreUpdate(page: PageCase) extends PageMsg

// enum OnEffectMsg extends Msg:
//   case OnSaved(isOver: Boolean) extends OnEffectMsg
