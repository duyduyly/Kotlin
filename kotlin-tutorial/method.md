## Method

1. void method
2. Return Method
3. Method have parameter
4. Method have Named Parameter
5. Method with default value
6. Nothing Method
7. Unlimited Parameters
#
__1. void method__

```kotlin
    fun sayHello(): Unit {
    println("Say Hello")
}
```

#

__2. Return Method__

- Two ways is same

```kotlin
    fun getAge(): Int {
    return 18
}

fun getAge1(): int = 18
```
#
__3. Method have parameter__

```kotlin
    fun sum(x: Int, y: Int): Int {
    return x + y
}

fun sum(x: Int, y: Int): Int = x + y
```
#
__4. Method have Named Parameter__

```kotlin
    fun main() {
    println(sum(a = 20, b = 30))
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

```
#
__5. Method with default value__

```kotlin
    fun main() {
    println(sum(x = 20))
}

fun sum(x: Int, y: Int = 20): Int = x + y
```
#
__6. Nothing Method__

_What is Nothing Method_

- Nothing is a type that has no values. It represents the type of value that never exists.This is mostly used to
  indicate that a function never returns normally (e.g. it always throws an exception or enters an infinite loop).

_Why should use Nothing method ?_

- Using Nothing as a return type tells the compiler
- this function will never return normally, and you don't have to worry about what happen next

__For Example__

```kotlin
fun main() {
    val name: String? = null
    val finalName = name ?: crash() // Kotlin knows finalName must be non-null here
}

fun crash(): Nothing {
    throw RuntimeException("Crash!")
}
```

a. Better type safety & compiler help
```kotlin
    //use Nothing 
  fun error(msg: String): Nothing = throw IllegalArgumentException(msg)
  
  fun getLength(text: String?): Int {
      val safeText = text ?: error("Text must not be null")
      return safeText.length  // Smart cast to non-null String
  }

```

```kotlin
  fun getLength2(text: String?): Int {
      if (text == null) {
          throw IllegalArgumentException("Text must not be null")
      }
      return text.length // Also works, but `text` needs to be smart-cast
  }
```
- Same outcome, but with Nothing, the intent is clearer and the code is more expressive.
b. Communicating intent
   - This function is supposed to crash, terminate, or never return.

#
7. Unlimited Parameters
```kotlin
  fun sum(vararg ints:Int) : Int{
    var sum = 0
    for (i in ints){
        sum += i
    }
    return sum
  }

  fun printSum(vararg ints:Int):Unit{
    val sum = sum(*ints)
    println(sum)
  }
```

## 

Tuples
- Have method can return multiple value
```kotlin
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
```