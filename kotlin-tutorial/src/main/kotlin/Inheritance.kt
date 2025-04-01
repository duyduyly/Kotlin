package org.example

fun main() {
    var dog = Dog();
    dog.talk()


    var cat = Cat();
    cat.talk()
}

class Inheritance {

}

open class Animal(var name: String="") { //use Open to can inherit class
    open fun talk(){} //want override a method, you must use open
}

class Dog : Animal("Dog"){

    override fun talk() {
        println("Gau gau")
    }
}

class Cat : Animal {
    init {
        this.name = "Cat"
    }
    constructor(name: String = "Mew") : super(name){

    }
    override fun talk() {
        println("Mew Mew")
    }
}

