import java.io.File
import java.io.InputStream

fun generate_data(file_name : String): Array<String> {
    val inputStream: InputStream = File(file_name).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it.replace('\n', '\u0000')) } }

    return lineList.toTypedArray()
}

fun getHorizontalByVerticalNoAim(data: Array<String>) : Int {
    var vertPos = 0
    var horiPos = 0

    for (string in data) {
        if (string.contains("up")) {
            vertPos -= string.last().digitToInt()
        } else if (string.contains("down")) {
            vertPos += string.last().digitToInt()
        } else if (string.contains("forward")) {
            horiPos += string.last().digitToInt()
        }
    }

    return vertPos * horiPos
}

fun getHorizontalByVerticalWithAim(data: Array<String>) : Int {
    var horiPos = 0
    var aim = 0
    var depth = 0

    for (string in data) {
        if (string.contains("up")) {
            aim -= string.last().digitToInt()
        } else if (string.contains("down")) {
            aim += string.last().digitToInt()
        } else if (string.contains("forward")) {
            horiPos += string.last().digitToInt()
            depth += aim * string.last().digitToInt()
        }
    }

    return horiPos * depth
}


fun day2PuzzleLogic(){
    println(getHorizontalByVerticalNoAim(generate_data("src\\main\\data\\d2_p1_data.txt")))
    println(getHorizontalByVerticalWithAim(generate_data("src\\main\\data\\d2_p1_data.txt")))
}