import java.io.BufferedReader
import java.io.StringReader

fun readNumber1(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }

    catch (e: NumberFormatException) {
        return null
    }

    finally {
        reader.close()
    }
}

fun readNumber2(reader: BufferedReader) {

    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }

    println(number)
}

fun main(args: Array<String>) {

    val reader1 = BufferedReader(StringReader("239"))
    println(readNumber1(reader1))

    val reader2 = BufferedReader(StringReader("not a number"))
    println(readNumber2(reader2))
}