## Deconstructing values  
- Deconstructing values refers to breaking a single object into multiple components using the destructuring declaration feature. It allows you to unpack a data object or a pair into individual variables in a concise and readable manner.


__use with normal object__
- we must create component1, component2, component3 to use deconstructing values
```kotlin
fun main() {
    val (title, link, description) = Video("Animation Demo", "https//:ssdsdsd","None")
    val (title4, link4) = Video("Animation Demo", "https//:ssdsdsd","None")
    println(title)
    println(link)
    println(description)
}
    
class Video(val title:String, val link:String, val des:String){
    operator fun component1() = title
    operator fun component2() = link
    operator fun component3() = des
}
```

__use data class__
- we needn't create component for each variable
```kotlin
fun main() {
    val (title, link, description) = Video2("Animation Demo", "https//:ssdsdsd","None")
    val (title3, link3) = Video2("Animation Demo", "https//:ssdsdsd","None")
    println(title)
    println(link)
    println(description)
}

 data class Video2(val title:String, val link:String, val des:String)
```