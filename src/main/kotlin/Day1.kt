import generateIntData

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

fun day1PuzzleLogic() {
    println(sonarSweepP1(generateIntData("src\\main\\data\\d1_p1_data.txt")))
    println(sonarSweepP2(generateIntData("src\\main\\data\\d1_p1_data.txt")))
}
