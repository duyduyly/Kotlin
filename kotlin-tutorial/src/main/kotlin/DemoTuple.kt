package org.example

class DemoTuple {
}

fun main() {
    println(getCity().first)
    println(getCity().second)

    println()
    println(getCountry().first)
    println(getCountry().second)
    println(getCountry().third)
}

fun getCity() : Pair<String, String>  = Pair("Ha Noi", "HN")
fun getCountry() : Triple<String, String, Int>  = Triple("Ha Noi", "HN", 84)