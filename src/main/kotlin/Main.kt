import day3PuzzleLogic
import java.io.File
import java.io.InputStream

// Data generation functions
fun generateStringData(file_name : String): Array<String> {
    val inputStream: InputStream = File(file_name).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it.replace('\n', '\u0000')) } }

    return lineList.toTypedArray()
}

fun generateIntData(file_name : String): IntArray {
    val inputStream: InputStream = File(file_name).inputStream()
    val lineList = mutableListOf<Int>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it.replace('\n', '\u0000').toInt()) } }

    return lineList.toTypedArray().toIntArray()
}

fun Boolean.toUInt() = if (this) (1).toUInt() else (0).toUInt()

fun main() {
    day3PuzzleLogic()
}