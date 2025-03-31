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


