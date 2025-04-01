## Type Casting 

__casting with basic data type__
```kotlin
    fun main(){
        var float :Float = 10.11f
        var int: Int = float.toInt()
        println(int)
    }
```

__Casting object__
```kotlin
    fun main() {
        //Object Casting
        var lap = createLaptop(Macbook())
        if (lap is Macbook) {
            lap.showMBPrice()
        }else if(lap is Dell) {
            lap.showDellPrice()
        }
    
        //use as to cast
        //
        var mac = lap as Macbook
        mac.showMBPrice()
    
        //If you do not want error you can "?"
        //because when casting fail compiler will skip this one
        println("Dell as?")
        val dell = lap as? Dell
        dell?.showDellPrice()
    
        //for lap is Macbook can not cast Dell Object
        val dell2 = lap as Dell
        dell2.showDellPrice()
    
    }
    
    fun createLaptop(lap: Laptop) = lap

    open class Laptop{}
    
    class Macbook : Laptop() {
        fun showMBPrice(){
            println("300$")
        }
    }
    
    class Dell : Laptop() {
        fun showDellPrice(){
            println("200$")
        }
    }
```
_Result_
```bash
10
300$
300$
Dell as?
Exception in thread "main" java.lang.ClassCastException: class org.example.Macbook cannot be cast to class org.example.Dell (org.example.Macbook and org.example.Dell are in unnamed module of loader 'app')
	at org.example.TypeCastingKt.main(TypeCasting.kt:34)
	at org.example.TypeCastingKt.main(TypeCasting.kt)
```