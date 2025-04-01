## Null Check
- allow nullable value 
- check value to do not throw NullPointer Exception
```kotlin
fun main(){
    var email :String? = null
    //println(email.length)//do not compile
    println(email?.length)
    
    //if you want throw exception you can
    //Compiler will check make sure variable have value
    println(email!!.length)
}
```
_Result:_
```bash
    null
    Exception in thread "main" java.lang.NullPointerException
        at org.example.MainKt.main(Main.kt:10)
        at org.example.MainKt.main(Main.kt)
```
- if you want your System do not crash when the value is null. you should use "DataType?"
- to avoid crash System
