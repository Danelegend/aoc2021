import generateStringData
import java.util.*
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt

fun determinePowerConsumption(data: Array<String>) : UInt {
    val bitCounter = bitCounter(data)
    var counter = data[0].length

    val bitLength = counter
    var gamma = (0).toUInt()
    for (num in bitCounter) {
        var temp = (num > data.size/2).toUInt()
        temp = temp shl (counter - 1)
        gamma = gamma or temp

        counter -= 1
    }

    return gamma * ((gamma.inv() shl 32 - bitLength) shr 32 - bitLength)
}

fun bitCounter(data: Array<String>): IntArray {
    val bitCounter = mutableListOf<Int>()
    var counter: Int = 0
    var flag: Boolean = false

    for (string in data) {
        counter = 0
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

    return bitCounter.toIntArray()
}

fun determineLifeSupportRating(data: Array<String>) : UInt {
    var numLines = 0

    for (string in data) {
        numLines += 1
    }

    return recursiveLogic(data, data[0].length, true) *
            recursiveLogic(data, data[0].length, false)
}

fun recursiveLogic(data: Array<String>, pos: Int, oxy: Boolean) : UInt {
    if (data.size == 1) {
        return Integer.parseInt(data[0], 2).toUInt()
    }

    val bitCounter = bitCounter(data)

    var value : UInt = if (oxy) {
        if (data.size % 2 == 1) {
            (bitCounter[bitCounter.size - pos] >= (round( (data.size*0.5 + 0.5)))).toUInt()
        } else {
            (bitCounter[bitCounter.size - pos] >= (round((data.size / 2).toDouble()))).toUInt()
        }
    } else {
        if (data.size % 2 == 1) {
            (bitCounter[bitCounter.size - pos] < (round((data.size*0.5 + 0.5)))).toUInt()
        } else {
            (bitCounter[bitCounter.size - pos] < (round((data.size / 2).toDouble()))).toUInt()
        }
    }

    val newArray = mutableListOf<String>()

    for (item in data) {
        val item2 = Integer.parseInt(item, 2)
        var temp = (item2 shl 32 - pos) ushr 31

        if (temp.toUInt() == value) {
            newArray.add(item)
        }
    }

    println(newArray.toString())

    return recursiveLogic(newArray.toTypedArray(), pos - 1, oxy)
}

fun day3PuzzleLogic() {
    println(determinePowerConsumption(generateStringData("src\\main\\data\\d3_p1_data.txt")))
    println(determineLifeSupportRating(generateStringData("src\\main\\data\\d3_p1_data.txt")))
}