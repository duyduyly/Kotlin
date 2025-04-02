package org.example.inherit

sealed class ParentClassA {
    class Success(val data: String = ""): ParentClassA()
}

open class ParentClassB {
    class Success(val data: String = ""): ParentClassA()
}

class Success2(val data: String = ""): ParentClassA()