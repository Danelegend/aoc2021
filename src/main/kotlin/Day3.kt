import generateStringData
import java.util.*
import kotlin.math.pow

fun determinePowerConsumption(data: Array<String>) : UInt {
    val bitCounter = mutableListOf<Int>()
    var counter: Int = 0
    var flag: Boolean = false
    var numLines: Int = 0

    for (string in data) {
        counter = 0
        numLines = numLines.inc()
        for (char in string.toCharArray()) {
            if (!flag) {
                bitCounter.add(char.digitToInt())
            } else {
                bitCounter[counter] += char.digitToInt()
            }

            counter = counter.inc()
        }
        flag = true
    }

    val bitLength = counter
    var gamma = (0).toUInt()
    for (num in bitCounter) {
        var temp = (num > numLines/2).toUInt()
        temp = temp shl (counter - 1)
        gamma = gamma or temp

        counter -= 1
    }

    return gamma * ((gamma.inv() shl 32 - bitLength) shr 32 - bitLength)
}

fun day3PuzzleLogic() {
    println(determinePowerConsumption(generateStringData("src\\main\\data\\d3_p1_data.txt")))
}