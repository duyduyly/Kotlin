## Extension functions

- Extension function is extend method for a class 

example:
```kotlin
fun main() {
    var pass: String = "12312414"
    //and I want check validate, but String pass do not have method validate
    //I must use extension function to create method validate
    println(pass.validatePass())
}

//extend method for String
fun String.validatePass(): Boolean {
    if (this.isBlank()) {
        return false
    }
    if (this.length > 6) {
        return true
    }
    
    return false
}

```

Result:
```bash
true
```