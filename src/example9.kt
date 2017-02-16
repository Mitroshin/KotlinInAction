package chapter2.examples

enum class Color1 {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class Color2 (val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0), ORANGE(255, 165, 0), BLUE(0, 0, 255), INDIGO(75, 0 , 130), VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}