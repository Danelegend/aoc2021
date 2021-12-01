import java.io.File
import java.io.InputStream

fun sonar_sweep(data : IntArray): Int {
    if (data.isEmpty() || data.size == 1) {
        return 0
    }

    var previous = data[0]
    var ret = 0

    for (i in 1 until data.size) {
        if (data[i] > previous) {
            ret = ret.inc()
        }
        previous = data[i]
    }

    return ret
}

fun generate_data(file_name : String): IntArray {
    val inputStream: InputStream = File(file_name).inputStream()
    val lineList = mutableListOf<Int>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it.replace('\n', '\u0000').toInt()) } }

    return lineList.toTypedArray().toIntArray()
}

fun day1_puzzle1_logic() {
    println(sonar_sweep(generate_data("D:\\Coding\\aoc2021\\src\\main\\data\\d1_p1_data.txt")))
}