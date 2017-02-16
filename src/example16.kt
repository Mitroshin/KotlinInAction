import java.io.BufferedReader

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