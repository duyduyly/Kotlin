
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

