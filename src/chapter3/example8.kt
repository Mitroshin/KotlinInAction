package chapter3

import chapter3.strings.joinToString

fun main(args: Array<String>) {
    val list = arrayListOf(1, 2, 3)

    println(list)
    println(list.joinToString(prefix = "#"))
    println(list.joinToString(separator = " | "))
}