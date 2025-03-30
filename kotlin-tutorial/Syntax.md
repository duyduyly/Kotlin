
# About Data Type

- in Kotlin must initialize value for variable
- if you do not define the data type for the variable then Kotlin automatic to knows this type based on your value

```kotlin

var name: String = "Alan" //ok
var name1 ="Alan01" //it's ok
var name2:String //not ok, for you must initialize value for variable
```
```kotlin
__Mutable__
var name:String = "Alan Mutable"
name = "Alan Change" //ok

__Immutable__
val name2: String = "constant name"
name2 = "name change" //not ok, compile error
```
# Data Type
- Int, Long, Float, String, Hex, Binary, char

__Example:__

```kotlin
val age: Int = 10
val age2 = 10

val myLong: Long = 10L
val myLong2 = 10L

val myFloat: Float = 10.1F
val myFloat2 = 10.1F

val myHex: Int = oxFF
val myBi: Int = Oxb11

var myChar: Chat = 'A'

//String
var myStr: String = "String Value"
val myStr2: String = "String val 2"
val mLines = """
    SELECT *
     FROM Table
     WHERE id = ''
""" //String multiple line
val myString3 = "I'm $myStr" //call myStr String with $ sign
val myString3 = "I'm ${age + 1}" // can calculate in String
```
#
__For Loop and Ranges:__

_Ranges_
```kotlin
    //1 -> 10
    println("1. ")
    for(item in 1..10){//print 1-10
        print("$item ->")
    }
    println()
    
    println("2. ")
    for (item in 1 until 10){ //just print 1-9
        print("$item ->")
    }
    
    println()
    
    println("3. ")
    var ranges = 1..10 //range is variable and transmit to for loop
    for (item in ranges){// 1-10
        print("$item ->")
    }
    println()
    
    println("4. ")
    for (item in 10 downTo 1){ //loop from 10 -> 1
        print("$item ->")
    }
    
    println()
    
    println("5. ")
    for (item in 1..10 step 2){ //loop with step is 2
        print("$item ->")
    }
    
    println()
    
    println("6. ")
    loop@ for (i in 1..3){ //loop with step is 2
        for (j in 1..3){
            println("i = $i <==> j = $j")
            if (j > i){
                break@loop //break outer loop in inner loop
            }
        }
        println("i = $i")
    }
```
__Result:__
```bash
    1. 
    1 ->2 ->3 ->4 ->5 ->6 ->7 ->8 ->9 ->10 ->
    2. 
    1 ->2 ->3 ->4 ->5 ->6 ->7 ->8 ->9 ->
    3. 
    1 ->2 ->3 ->4 ->5 ->6 ->7 ->8 ->9 ->10 ->
    4. 
    10 ->9 ->8 ->7 ->6 ->5 ->4 ->3 ->2 ->1 ->
    5. 
    1 ->3 ->5 ->7 ->9 ->
    6. 
    i = 1 <==> j = 1
    i = 1 <==> j = 2
```
#
__While:__
```kotlin
    var item = 10
    while(item < 15){
        print("$item ->")
        item++
    }
```

__Result:__
```bash
  10 ->11 ->12 ->13 ->14 ->
```
#
__Do While:__
```kotlin
    var item = 100
    do{
        print(item)
        item++
    }while(item < 115)
```

__Result:__
```bash
  100 ->101 ->102 ->103 ->104 ->105 ->106 ->107 ->108 ->109 ->110 ->111 ->112 ->113 ->114 ->
```
#
## Condition


__if-elseif-else__

__Example__

```kotlin
    var number = (1..100).random()
    println("Random value $number")
    
    //If-else Block 
    println("If-else Block ")
    if (number % 2 == 0) {
        println("Random value $number is Oven")
    } else {
        print("Random value $number is Odd")
    }
    
    //if else if value
    println("If else if value")
    if (number > 50) {
        print("Random value $number greater than 50")
    } else if (number < 100) {
        println("Random value $number less than 100")
    } else {
        println("Random value greater than 50 or less than 100 ")
    }
    
    //if else return value
    println("if else return value")
    val resutl = if (number < 5) {
        "Random value $number  less than five"
    } else if (number < 10) {
        "Random value $number less than ten"
    } else {
        "Random value $number is else Condition"
    }
    
    println("Result $resutl")

```
__Result:__
```bash
    Random value 30

    If-else Block 
    Random value 30 is Oven
    
    If else if value
    Random value 30 less than 100
    
    if else return value
    Result Random value 30 is else Condition
```
- if you use 'if' returning value, you must 'else' block in condition
#
__When Condition__
- when <==> switch-case 

__Example:__

```kotlin
    var number = (1..100).random()
    println("Random value $number")
    
    when (number) {
        in 1..16 -> {
            println("Case 1 -> 16 ")
        }
        18 -> {
            println("Case 18")
        }
        in 19..100 -> {
            println("Case 19 -> 100")
        }
    
        else -> {
            println("Exception")
        }
    }
    
    //return value
    val result = when (number) {
        in 1..16 -> {
            "from 1 to 16"
        }
        18 -> {
            "enough 18"
        }
        in 19..100 -> {
            "from 19 to 100"
        }
    
        else -> {
            "Exception"
        }
    }
    
    println("Condition Result: $result")
```
_Result:_
```bash
    Random value 95
    Case 19 -> 100
    Condition Result: from 19 to 100
```




