package org.example

fun main() {
    var userRepo = UserRepoImpl()
    userRepo.saveUser()
    userRepo.findById("2323")
    println(userRepo.ageDefault)
}

class User {
}

interface  IUserRepo{
    var ageDefault: Int //absolute difference with java

    fun saveUser()
    fun findById(userId: String){
        println("$userId printed") //implemented in interface, so we do not need to implement the method
    }
}
class UserRepoImpl : IUserRepo,A{
    override var ageDefault:Int = 20 //we can override variable

    override fun saveUser() {
        println("Save User")
    }

    override fun findById(userId: String) {
        super.findById(userId)
        println("find User")
    }

}

interface A{

}
