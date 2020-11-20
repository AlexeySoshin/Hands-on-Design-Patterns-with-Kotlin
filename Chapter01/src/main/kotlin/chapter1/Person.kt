package chapter1

fun main() {
    println("Hello, world!")

    val p = Person()
    p.name = "Alex"
    println(p.name)
}

class Person {
    var name : String = ""
        set(value) {
            field = value.toUpperCase()
        }
}