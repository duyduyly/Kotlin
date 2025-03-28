
# Type

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




