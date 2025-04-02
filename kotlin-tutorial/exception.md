## Exception

- Exception in Kotlin Similar with Java
```kotlin
import kotlin.Exception

fun main(){
    try {
        var float = 10 / (0..1).random()
        println(float)
    }catch (e: Exception) {
        println(e.message)
    }finally {
        println("Finally")
    }
}
```
#
__Custom Exception__
```kotlin
    fun main(){
        try{
            var number = parseFloat(123)
            println(number)
        }catch (e: CustomException){
            println(e.toString())
        }
    }
    
    fun parseFloat(s: Any):Float{
        if (s is Int){
            throw CustomException("Cast Error")
        }
        return (s as String).toFloat()
    }
    
    class CustomException(val msg: String) :Throwable(msg){}
```
Result:
```bash
    org.example.CustomException: Cast Error
```
#
__Assign Exception__
```kotlin
    fun main(){
        var result = try{
            var number = parseFloat(123)
            println(number)
            number.toString()
        }catch (e: CustomException){
            println(e.toString())
            e.toString()
        }
    
        println("Result is: $result")
    }
    
    fun parseFloat(s: Any):Float{
        if (s is Int){
            throw CustomException("Cast Error")
        }
        return (s as String).toFloat()
    }
    
    class CustomException(val msg: String) :Throwable(msg){}
```
Result:
```bash
    org.example.CustomException: Cast Error
    Result is: org.example.CustomException: Cast Error
```

