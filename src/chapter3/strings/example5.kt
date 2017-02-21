package chapter3.strings

fun String.lastChar1(): Char =
        this.get(this.length - 1)

fun String.lastChar2(): Char =
        get(length-1)

val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        setCharAt(length - 1, value)
    }

fun main(args: Array<String>) {
    println("Kotlin".lastChar2())

    val stringBuilder = StringBuilder("Kotlin")
    stringBuilder.lastChar = '!'
    println(stringBuilder)
}