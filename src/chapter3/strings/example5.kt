package chapter3.strings

fun String.lastChar1(): Char =
        this.get(this.length - 1)

fun String.lastChar2(): Char =
        get(length-1)

fun main(args: Array<String>) {
    println("Kotlin".lastChar2())
}