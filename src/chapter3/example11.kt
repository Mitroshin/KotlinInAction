package chapter3

fun View.showOff() = println("I'm view")
fun Button.showOff() = println("I'm button")

fun main(args: Array<String>) {
    val view: View = Button()
    view.showOff()
}