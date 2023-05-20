package parseto.common.function
object Log:
  def log[A](x: A): A =
    println(x); x
  def log2[A](str: String)(x: A): A =
    println(str); println(x); x
