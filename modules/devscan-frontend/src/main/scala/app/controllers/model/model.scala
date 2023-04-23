package app

final case class Model(
    pointer: Int,
    appStates: List[StateCase],
    depth: List[Map[String, Boolean]] = List(
      Map("Json" -> true),
      Map("Json" -> true),
      Map("Json" -> true),
      Map("Json" -> true),
      Map("Json" -> true)
    )
)
