package chapter3

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory")
    println("Name: $fileName")
    println("Ext: $extension")
}

fun parsePathRegexp(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)

    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory")
        println("Name: $fileName")
        println("Ext: $extension")
    }
}

fun main(args: Array<String>) {
    parsePath("C:/Users/Dmitry/Documents/Kotlin/KotlinInAction/src/chapter3/example14.kt")
    println()
    parsePathRegexp("C:/Users/Dmitry/Documents/Kotlin/KotlinInAction/src/chapter3/example14.kt")
}