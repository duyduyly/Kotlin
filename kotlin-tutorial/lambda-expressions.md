## Lambda Expressions
- Lambda expression in Kotlin is a concise way to represent a function that can be passed as an argument to another function.

__Basic Syntax:__
```kotlin
val lambdaName: (ParameterType) -> ReturnType = { parameterName -> body }
``` 

__Example 1: Simple Lambda Expression__
```kotlin
val sum: (Int, Int) -> Int = { a, b -> a + b }

println(sum(3, 5))  // Output: 8

```
__Example 2: Lambda without parameters__
```kotlin
val printMessage = { println("Hello Kotlin Lambda") }

printMessage()  // Output: Hello Kotlin Lambda
```

__Example 3: Lambda with `it` keyword (Single Parameter)__
- If the lambda has only one parameter, it is used implicitly.
```kotlin
val square: (Int) -> Int = { it * it }

println(square(4))  // Output: 16
```

__Example 4: Passing Lambda to Function__
```kotlin
fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

val result = operateOnNumbers(10, 5) { x, y -> x * y }

println(result)  // Output: 50
```

__Example 5: Lambda with filter and map__
```kotlin
val list = listOf(1, 2, 3, 4, 5)

val evenNumbers = list.filter { it % 2 == 0 }

println(evenNumbers)  // Output: [2, 4]

```
# Note
Lambda expressions in Kotlin are treated as objects of type Function.
Kotlin also supports higher-order functions (functions that take functions as parameters or return functions).

https://chatgpt.com/share/67f5f056-bf60-8011-93d2-4faa804ec46d
_(source from chat gpt)_



## Lambda Extension

In Kotlin, lambda extension usually refers to extension functions that are defined using lambda expressions.

What is an Extension Function?
- An extension function is a way to add a new function to an existing class without modifying its source code.
- It's when an extension function has a lambda parameter — usually to customize behavior.
Basic Syntax:
```kotlin
fun ClassName.functionName() {
    // function body
}
```
__Example 1 — Extension Function with Lambda Parameter__
```kotlin
fun String.customPrint(action: (String) -> Unit) {
    action(this)
}

fun main() {
    val name = "Kotlin"

    name.customPrint { str ->
        println("Hello from $str")
    }
}
```
__Example 2 — Lambda Extension Returning Value__
```kotlin
fun Int.applyTwice(operation: (Int) -> Int): Int {
    return operation(operation(this))
}

fun main() {
    val result = 3.applyTwice { it * 2 }

    println(result)  // Output: 12
}

```

__Example 3 — Lambda Receiver (with `this`)__

Lambda extensions can also use lambda with receiver (where this refers to the object).

```kotlin
fun buildString(block: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.block()   // Here `block` is lambda extension on StringBuilder
    return sb.toString()
}

fun main() {
    val result = buildString {
        append("Hello, ")
        append("Kotlin!")
    }

    println(result)  // Output: Hello, Kotlin!
}

```

__Most Common Built-in Kotlin Functions that Support Lambda Extension:__
## Color Reference

| Method Name             | Description                                                                | Receiver type inside lambda            | Example Usage             |
| ----------------- | ------------------------------- | ---------------- | ---------------------------------- |
| `apply {}` | Configure and return receiver object |`this` (receiver) |`val user = User().apply { name = "Tom" }` |
| `run {}` | Execute code block and return result |`this` (receiver) |`val length = "Hello".run { length }` |
| `with(object) {}` | Run block with receiver |`this` (receiver) |`with(user) { println(name) }` |
| `let {}` | Pass object as argument |`it ` (parameter) |`val result = name?.let { it.uppercase() }` |
| `also {}` | Perform extra operations, return object |`it` (parameter) |`user.also { println(it.name) }` |
| `takeIf {}` | Return object if condition is true |`it` (parameter) |`val result = name.takeIf { it.length > 3 }` |
| `filter {}` | Filter elements in collections |`it` (element) |`list.filter { it > 5 }` |
| `map {}` | Transform elements |`it` (element) |`list.map { it * 2 }` |

## Example Usage in Real Code
```kotlin
data class User(var name: String, var age: Int)

val user = User("Alice", 20)

// apply -> initialize object
val newUser = User("", 0).apply {
    name = "Bob"
    age = 25
}

// run -> do something with result
val message = user.run {
    "User: $name is $age years old"
}

// let -> safe call or transformation
val length = user.name.let { it.length }

// also -> do side effects
user.also { println("User created: $it") }

// takeIf -> conditional return
val validName = user.name.takeIf { it.isNotEmpty() }

// filter/map -> collections
val numbers = listOf(1, 2, 3, 4, 5)

val evenSquares = numbers
    .filter { it % 2 == 0 }
    .map { it * it }

```


reference here: https://chatgpt.com/share/67f5f056-bf60-8011-93d2-4faa804ec46d