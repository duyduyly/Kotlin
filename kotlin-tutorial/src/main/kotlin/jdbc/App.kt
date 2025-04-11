package org.example.jdbc

import org.example.jdbc.service.StudentService

fun main() {
    val studentService = StudentService()
    studentService.createStudent()
    studentService.handleFunction()
}

