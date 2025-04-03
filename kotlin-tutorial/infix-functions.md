## Infix Function
- it's so interesting
- it used Extension Function to extend the class
```kotlin
    fun main(){
        // Infix Function
        val number: Int = 100
        val result:String = (number + 100).toString()
    
        val number2 = number cong 20
    
        println(number2)
        
    }
    infix fun Int.cong(number: Int) = this + number
```
Result:
```bash
    120
```