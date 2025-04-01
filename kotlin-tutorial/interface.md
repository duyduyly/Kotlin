## Interface
- Can multiple inheritance
- Must do implement when class implement this interface 
- support default method similar java 8
- special: we can override variable in interface
- use supper to call parent to call default method (similar with java language)

```kotlin
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


```