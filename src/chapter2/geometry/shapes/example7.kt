package chapter2.geometry.shapes

import chapter2.Rectangle
import java.util.*

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

fun main(args: Array<String>) {
    println(createRandomRectangle().isSquare)
}