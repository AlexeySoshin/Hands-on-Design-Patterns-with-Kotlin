package chapter2

fun main() {

    val n = NumberMaster()
    println(NumberMaster.valueOf("123"))
}

class NumberMaster {
    companion object Parser {
        fun valueOf(hopefullyNumber: String) : Long {
            return hopefullyNumber.toLong()
        }
    }
}
