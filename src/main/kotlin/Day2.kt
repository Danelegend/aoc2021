import generateStringData

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
    println(getHorizontalByVerticalNoAim(generateStringData("src\\main\\data\\d2_p1_data.txt")))
    println(getHorizontalByVerticalWithAim(generateStringData("src\\main\\data\\d2_p1_data.txt")))
}