package chapter6

fun main() {

    val numbers = (1..5)

    numbers.map { it * it }
            .filter { it < 20 }
            .sortedDescending()
            .forEach { println(it) }

    numbers.map { it * it }
            .forEachIndexed { index, value ->
                print("$index:$value, ")
            }
}