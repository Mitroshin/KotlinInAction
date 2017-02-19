package chapter3

var opCount = 0

fun performOperation() {
    opCount++
    // ...
}

fun reportOperationCount() {
    println("Operation performed $opCount times")
}

fun main(args: Array<String>) {
    performOperation()
    reportOperationCount()
}