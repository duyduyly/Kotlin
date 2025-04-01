package org.example

class TypeCasting {
}

fun main() {
    //basic type casting
    var float :Float = 10.11f
    var int: Int = float.toInt()
    println(int)


    //Object Casting
    var lap = createLaptop(Macbook())
    if (lap is Macbook) {
        lap.showMBPrice()
    }else if(lap is Dell) {
        lap.showDellPrice()
    }

    //use as to cast
    //
    var mac = lap as Macbook
    mac.showMBPrice()

    //If you do not want error you can "?"
    //because when casting fail compiler will skip this one
    println("Dell as?")
    val dell = lap as? Dell
    dell?.showDellPrice()

    //for lap is Macbook can not cast Dell Object
    val dell2 = lap as Dell
    dell2.showDellPrice()

}

fun createLaptop(lap: Laptop) = lap

open class Laptop{

}

class Macbook : Laptop() {
    fun showMBPrice(){
        println("300$")
    }
}

class Dell : Laptop() {
    fun showDellPrice(){
        println("200$")
    }
}