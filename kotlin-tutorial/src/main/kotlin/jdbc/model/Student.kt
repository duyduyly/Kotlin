package org.example.jdbc.model

data class Student(var id:Long = 0, var name:String= "", var age:Int=0) {
    companion object {
        fun getTableTitle(): String {
            return "ID       |Age      |Name\n" +
                    "--------------------------"
        }
    }
    override fun toString(): String {
        return "$id       |$age      |$name"
    }
}