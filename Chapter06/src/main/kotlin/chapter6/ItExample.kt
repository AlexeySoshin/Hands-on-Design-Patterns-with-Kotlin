package chapter6

fun main() {
    val noParameters = { 1 } // () -> Int
    val oneParameterVeryVeryExplicit = oneParameter { x: Int -> x.toLong() }
    val oneParameterVeryExplicit = oneParameter { x: Int -> x.toLong() }
    val oneParameterExplicit = oneParameter { x -> x.toLong() }
    val oneParameterImplicit = oneParameter { it.toLong() }
}

fun oneParameter(block: (Int) -> Long) {}