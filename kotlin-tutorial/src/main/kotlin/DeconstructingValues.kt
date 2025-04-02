package org.example

class DeconstructingValues {

}

//deconstructing values refers to breaking a single object into multiple components using the destructuring declaration feature.
//It allows you to unpack a data object or a pair into individual variables in a concise and readable manner.
fun main() {
    val (title, link, description) = Video("Animation Demo", "https//:ssdsdsd","None")
    val (title4, link4) = Video("Animation Demo", "https//:ssdsdsd","None")
    println(title)
    println(link)
    println(description)

    val (title2, link2, description2) = Video2("Animation Demo", "https//:ssdsdsd","None")
    val (title3, link3) = Video2("Animation Demo", "https//:ssdsdsd","None")
    println(title2)
    println(link2)
    println(description2)
}


class Video(val title:String, val link:String, val des:String){
    operator fun component1() = title
    operator fun component2() = link
    operator fun component3() = des
}
 data class Video2(val title:String, val link:String, val des:String)