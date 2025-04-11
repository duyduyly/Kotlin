package org.example

fun main() {
    val demoLambda: (Int, Int, Int, Int) -> Int = { a, b, c, d -> a + b + c + d };
    println(1 + 2 + 3 + 4)

    val checkTwoDouble: (Double, Double) -> Boolean = { a, b ->
        if (a == b) true
        else if (a > b) true
        else false
    }

    val a1: Double = 4.00
    val b: Double = 3.00

    var result = checkTwoDouble(a1, b)
    println(checkAandB(a1, b, { a, b ->
        if (a == b) true
        else if (a > b) true
        else false
    }))

    var a = 2
    buildString {
        if (a == 2) {
            append(a)
        }
    }
}

fun checkAandB(a: Double, b: Double, lambda: (Double, Double) -> Boolean): Boolean {
    return lambda(a, b)
}

class LambdaExpression {
    fun buildString(builder: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        stringBuilder.builder()
        return stringBuilder.toString()
    }
}


