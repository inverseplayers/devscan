package example

object Math:
  def add(a: Int)(b: Int) = a + b
  val added_1 = Math add 1

object Programs:
  def main(args: Array[String]): Unit =
    print(Math added_1 2)
