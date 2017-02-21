package chapter3

fun main(args: Array<String>) {

    val arrayString = arrayOf("one", "tho", "three")
    val arrayInt = arrayOf(1, 2, 3)

    val listString = listOf("arrayString: ", *arrayString)
    println(listString)

    val listInt = listOf(*arrayInt)
    println(listInt)
}