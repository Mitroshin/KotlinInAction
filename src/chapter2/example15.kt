package chapter2

fun recognize(c: Char) = when (c) {
    in '0' .. '9' -> "It's a digit!"
    in 'a'.. 'z', in 'A' .. 'Z' -> "It's a letter!"

    else -> "I don't know..."
}

fun main(args: Array<String>) {
    println("8 is a ${recognize('8')}")
    println("g is a ${recognize('g')}")
    println("@ is a ${recognize('@')}")
}