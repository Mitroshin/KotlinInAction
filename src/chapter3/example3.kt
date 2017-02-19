package chapter3

import chapter3.strings.joinToString

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4)
    println(joinToString(list, separator = ";", prefix = "[", postfix = "]"))
    println(joinToString(list))
    println(joinToString(list, separator = ";"))
}