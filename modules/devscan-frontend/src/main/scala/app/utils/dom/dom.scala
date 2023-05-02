package app

import org.scalajs.dom.window

object Dom:
  // currently only use className selection, but could be update as more generic fuction
  def select(className: String) =
    window.document.getElementsByClassName(s"$className").item(0)

  def getDimensions() =
    val size = Map(
      "doc" -> Map("x" -> 0, "y" -> 0),
      "win" -> Map("x" -> 0, "y" -> 0),
      "mini_doc" -> Map("x" -> 0, "y" -> 0),
      "mini_win" -> Map("x" -> 0, "y" -> 0)
    )

    def gen_Ratio(a: Double, b: Double) = a / b

    val winR = gen_Ratio(size("win")("y"), size("win")("x"))
    val docR = gen_Ratio(size("doc")("y"), size("doc")("x"))
    val mini_scale = gen_Ratio(size("mini_doc")("x"), size("doc")("x"))
