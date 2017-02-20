package chapter3

import chapter3.strings.joinToString

fun Collection<String>.join(
        separator: String = ", ",
        prefix:String = "",
        postfix:String = ""
) = joinToString(separator, prefix, postfix)

fun main(args: Array<String>) {
    println(listOf("one", "two", "eight").join(" "))
//    println(listOf(1, 2, 8).join())
}