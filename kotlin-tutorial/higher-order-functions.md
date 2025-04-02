## Higher Order Functions
- we can create function have parameter is a Function

```kotlin
fun main(){
    
    //normal use
    var result = calculate(1,2, ::execute)
    println(result)
    
    //use anonymous method
    var result1 = calculate(3,4, fun(x,y :Int) :Int{
        return x+y
    })
}

fun calculate(x: Int, y: Int, func: (Int, Int)-> Int) : Int{
    return func(x, y)
}

fun execute(x: Int, y:Int) = x + y
```