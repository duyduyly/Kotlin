package org.example


class ObjectClass : BookRepo() {
    override fun selectBook() { //must be implementation abstract class in class inherited
        println("Selected book")
    }
}

abstract class BookRepo{
    var table = "book"
    abstract fun selectBook()
    fun saveBook(){}
}