package app

final case class Model(
    pointer: Int,
    appStates: List[StateCase],
    depth: Depth = Depth()
)
