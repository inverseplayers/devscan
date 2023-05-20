package parseto.common.function
object Log:
  def log[A](x: A): A =
    println(x); x
