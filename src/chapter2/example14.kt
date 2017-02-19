package chapter2

fun isLetter(c: Char) = c in 'a' .. 'z' || c in 'A' .. 'Z'

fun isNotDigit(c: Char) = c !in '0'.. '9'

fun main(args: Array<String>) {
    println("g is letter = ${isLetter('g')}")
    println("5 is letter = ${isLetter('5')}")
    println("g is not digit = ${isNotDigit('g')}")
    println("5 is not digit = ${isNotDigit('5')}")
}