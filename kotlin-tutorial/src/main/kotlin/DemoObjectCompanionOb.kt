package org.example

fun main() {
    print(Guru.Math.PI)

    print(Guru2.PI) // it's similar "public static final float Pi = 3.14" in java
    Guru2.makeGuru() // == "public static void makeGuru(){sout("makeGuru")}" in java
}


class Guru{
    object Math{
        var PI = 3.14
    }
}

class Guru2{
    companion object Math{
        var PI = 3.14
        fun makeGuru() : Unit{
            println("makeGuru")}
    }
}


object SingletonKotlin{
    var name = "Kotlin"
    fun doSomething(){}
}