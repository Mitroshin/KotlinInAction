package chapter3

import chapter3.strings.joinToString

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4)
    println(list.joinToString(separator = ";", prefix = "[", postfix = "]"))
    println(list.joinToString())
    println(list.joinToString(separator = ";"))
}