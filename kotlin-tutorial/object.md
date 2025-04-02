## Object 

_Object in class_
```kotlin
package org.example

fun main() {
    print(Guru.Math.PI)
}


class Guru{
    object Math{
        var PI = 3.14
    }
}
```

when use companion object
```kotlin
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

```
#
__Constant in Kotlin__
- in Object Math is Constant 
```kotlin

fun main() {
    print(Math.PI) 
}

object Math{ 
        var PI = 3.14
    }
```