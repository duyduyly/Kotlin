package org.example
fun main(){
    val demoLambda: (Int, Int, Int, Int) -> Int = {a,b,c,d -> a+b+c+d};
    println(1+2+3+4)


    var  a = 2
    buildString {
        if (a == 2){
            append(a)
        }

    }
}
class LambdaExpression {
    fun buildString(builder: StringBuilder.() -> Unit): String {
        val stringBuilder = StringBuilder()
        stringBuilder.builder()
        return stringBuilder.toString()
    }
}


