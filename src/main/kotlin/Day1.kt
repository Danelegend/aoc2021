import java.io.File
import java.io.InputStream

fun sonarSweepP1(data : IntArray): Int {
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

fun sonarSweepP2(data : IntArray): Int {
    if (data.isEmpty() || data.size < 4) {
        return 0
    }

    var previous = data[0] + data[1] + data[2]
    var ret = 0

    for (i in 1 until data.size - 2) {
        if (data[i] + data[i+1] + data[i+2] > previous){
            ret = ret.inc()
        }

        previous = data[i] + data[i+1] + data[i+2]
    }

    return ret
}

fun generateData(file_name : String): IntArray {
    val inputStream: InputStream = File(file_name).inputStream()
    val lineList = mutableListOf<Int>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it.replace('\n', '\u0000').toInt()) } }

    return lineList.toTypedArray().toIntArray()
}

fun day1PuzzleLogic() {
    println(sonarSweepP1(generateData("src\\main\\data\\d1_p1_data.txt")))
    println(sonarSweepP2(generateData("src\\main\\data\\d1_p1_data.txt")))
}
