package chapter5.immutability


fun main() {
    // to() function creates a Pair tuple
    val pair = "a" to 1

    // You can destructure a tuple using destructuring syntax
    val (key, value) = pair

    for (p in mapOf(1 to "Sunday", 2 to "Monday")) {
        println("${p.key} ${p.value}")
    }

}