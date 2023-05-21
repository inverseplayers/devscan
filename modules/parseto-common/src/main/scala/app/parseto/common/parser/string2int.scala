package app.parseto.common.parser

def string_digit_2int(string: String): String | Int =
  string.forall(Character.isDigit) match
    case true  => string.toInt
    case false => string
