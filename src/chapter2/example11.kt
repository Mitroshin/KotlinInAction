package chapter2

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "

    else -> "$i "
}

fun main(args: Array<String>) {

    val range1 = 1 .. 100
    for (i in range1) {
        print(fizzBuzz(i))
    }

    val range2 = 100 downTo 1 step 2
    for (i in range2) {
        print(fizzBuzz(i))
    }

    val range3 = 1 until 100
    for (i in range3) {
        println(i)
    }
}