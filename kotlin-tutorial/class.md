## Class

```kotlin
fun main(){
    var student = Student()
    //don't need use 'new' in Java to create instance

    student.showInfo()
}

class Student{
    //props, method
    var name = "Ryan Nguyen"
    var age = 25
    
    fun showInfo(){
        println(this.age)
        println(this.name)
    }
}
```

__Constructor__
1. Primary constructor
```kotlin
    fun main(){
        var customer = Customer("Alan", "0923232")
        var customer2 = Customer2("Alan", "0923232")
        val customer3 = Customer3()
        customer3.showInfo() //although default value equal empty but variable have value in 'Init{}'
    }

    //solution 1
    class Customer (var name: String, var phone:String){
        
    }

    //solution 2
    class Customer2 constructor(var name: String, var phone:String){
    
    }

    //solution 3, use init to initial value of variable in primary constructor
    class Customer3 (var name: String = "", var phone:String = ""){
        init {
            this.name = "Alan"
            this.phone = "12313123213"
        }

        fun showInfo(){
            println(this.age)
            println(this.name)
        }
    }
```
2. Secondary Constructor
```kotlin
     fun main(){
    val customer = Customer("sdasdas@Gmail.com")
    customer.showInfo() 
}

    class Customer(var name: String = "", var phone: String = "") {
        var email: String = ""
    
        init {
            this.name = "Alan"
            this.phone = "12313123213"
        }
    
        constructor(email: String) : this() {
            this.email = email
        }
    
        fun showInfo() {
            println(this.age)
            println(this.name)
            println(this.email)
        }
}
```

3. Setter/Getter in class
```kotlin
    fun main() {
        val customer = Customer("sdasdas@Gmail.com")
        customer.email = "asdjasdjaslkdjlad"
        customer.showInfo()
    }
    
    class Customer(var name: String = "", var phone: String = "") {
        //create setter getter for email
        var email: String = ""
            set(newEmail) {
                field = newEmail
            }
            get() = field
    
    
        constructor(email: String) : this() {
            this.email = email
        }
    
        fun showInfo() {
            println(this.age)
            println(this.name)
            println(this.email)
        }
    }
```
- note: if variable use val, variable will not change value
- access modifier
- public : all package can call
- private: can't call outside of class
- protected : just subClass can call
- internal: internal just use inner module ()

#

## Data Class
```kotlin
    fun main(){
        var book1 = Book("Kotlin Programming", "Ryan", "2020")
        var book2 = Book("Kotlin Programming", "Ryan", "2020")
        
        println(book1 == book2)
        println(book1.toString())
    
        var baby1 = Baby("A", 1)
        var baby2 = Baby("A", 1)
        println(baby1 == baby2)
        println(baby1.toString())
    }

    data class Book(val title: String, val author:String, val date: String)

    class Baby(val name:String, val age:Int)
```
_Result_
```bash
    true
    Book(title=Kotlin Programming, author=Ryan, date=2020) //Data support toString, Equal and hashCode Method like Java Program
    false
    org.example.Baby@6e8cf4c6 
```
Data class
- Data support toString, Equal and hashCode Method like Java Program

#
## Enum Class
```kotlin
    fun main(){
        var env = Env.PROC
        println(env)
        println(env.toString())
        println(env.name)
        println(env.ordinal)
    
        println("==================")
        for (item in Env.values()){
            println("$item value: ${item.value}")
        }
    
    }
    
    enum class Env(val value:Int){
        PROC(100),
        STAGING(200),
        DEVELOPMENT(300)
    }
```
_Result_
```bash
    PROC
    PROC
    PROC
    0
    ==================
    PROC value: 100
    STAGING value: 200
    DEVELOPMENT value: 300
```

__Override Method in Enum__

__For Example 1__
```kotlin
   enum class Env(val value:Int){
        PROC(100){
            override fun toString(): String {
                return "Override"
}
        },
        STAGING(200),
        DEVELOPMENT(300)
    }
```
__For Example 2__
```kotlin
   enum class Env(val value:Int){
        PROC(100){
            override fun transform(): String {
                return "Override"
}
        },
        STAGING(200){
            override fun transform(): String {
                return "STAGING(200)"
            }
        },
        DEVELOPMENT(300){
            override fun transform(): String {
                return "DEVELOPMENT(300)"
            }
        };
    
        abstract fun transform(): String
    }
```