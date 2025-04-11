package org.example.jdbc.service

import org.example.jdbc.model.Student
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.*

class StudentService {
    val jdbcUrl = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"  // In-memory DB
    val conn = DriverManager.getConnection(jdbcUrl)

    private fun menu(): Unit {
        val menu = """
       1.Insert Student
       2.Show list Students
       3.Update Student by Id
       4.Delete Student By Id
       5.Find Student By Name
       6.Find Student By Id
       0.Exist System
    """.trimIndent()
        println(menu)
    }

    fun handleFunction(): Unit {
        var chooseNumber: Int? = null
        while (chooseNumber != 0) {
            this.menu()
            println("Choose Function: ")
            chooseNumber = readlnOrNull()?.toIntOrNull() ?: 99
            when (chooseNumber) {
                1 -> {
                    val student = Student()
                    println("Enter Name: ")
                    student.name = readlnOrNull() ?: ""
                    println("Enter age: ")
                    student.age = readlnOrNull()?.toIntOrNull() ?: 0
                    insertStudent(listOf(student))
                }

                2 -> {
                    val students = this.findStudent("SELECT * FROM STUDENT")
                    println(Student.getTableTitle())
                    students.forEach { student -> println(student) }
                    println()
                }

                3 -> {
                    this.updateById(this.enterId())
                }

                4 -> {
                    this.removeStudent(this.enterId())
                }

                5 -> {
                    this.findByName(readlnOrNull() ?: "", true)
                }

                6 -> {
                    this.findById(this.enterId(), true)
                }

                else -> println("Invalid Option")
            }
        }
        conn.close()
        println("Exist Program")
    }

    private fun enterId(): Long {
        println("Enter Student Id: ")
        return readlnOrNull()?.toLong() ?: 0
    }

    fun createStudent(): Unit {
        val sql = """
            CREATE TABLE STUDENT (
                id INT PRIMARY KEY AUTO_INCREMENT,
                NAME VARCHAR(100),
                AGE INT
            )
    """.trimIndent()
        conn.createStatement().use { it.execute(sql) }
    }

    private fun insertStudent(userList: List<Student>) {
        val sql = "INSERT INTO STUDENT (name, age) VALUES (?,?)"
        conn.prepareStatement(sql).use { stmt ->
            userList.forEach {
                buildStmt(it.name, it.age, stmt)
            }
        }
    }

    private fun buildStmt(name: String, age: Int, stmt: PreparedStatement): Unit {
        stmt.setString(1, name)
        stmt.setInt(2, age)
        stmt.executeUpdate()
    }

    private fun updateById(id: Long) {
        val student = findById(id, false)
        if (student != null) {
            println("Change name or Default ${student.name}")
            student.name = readlnOrNull() ?: student.name
            println("Change age or Default ${student.age}")
            student.age = readlnOrNull()?.toIntOrNull() ?: student.age

            conn.prepareStatement("UPDATE STUDENT SET NAME=?, AGE=? WHERE ID = ?").use { stmt ->
                stmt.setString(1, student.name)
                stmt.setInt(2, student.age)
                stmt.setLong(3, id)
                stmt.executeUpdate()
            }
        }
    }

    private fun findById(id: Long, isShow: Boolean): Student? {
        val findStudent = findStudent("SELECT * FROM STUDENT WHERE id = $id")
        if (findStudent.isEmpty()) {
            println("Student Not found"); return null
        }
        if (isShow) println(findStudent)
        return findStudent[0]
    }

    private fun findByName(name: String, isShow: Boolean): Student? {
        val findStudent = findStudent("SELECT * FROM STUDENT WHERE name = '$name'")
        if (findStudent.isEmpty()) {
            println("Student Not found"); return null
        }
        if (isShow) println(findStudent)
        return findStudent[0]
    }

    private fun removeStudent(id: Long) {
        val preparedStatement = conn.prepareStatement("DELETE FROM STUDENT WHERE id = ?")
        preparedStatement.setLong(1, id)
        val rowsAffected = preparedStatement.executeUpdate()

        if (rowsAffected > 0) {
            println("User deleted successfully.")
        } else {
            println("User not found.")
        }
        preparedStatement.close()
    }

    private fun findStudent(query: String): List<Student> {
        val students = mutableListOf<Student>()
        conn.createStatement().use { stmt ->
            stmt.executeQuery(query).use { rs ->
                while (rs.next()) {
                    students.add(setStudent(rs, query))
                }
            }
        }
        return students
    }


    private fun setStudent(rs: ResultSet, query: String): Student {
        val student = Student()
        val splitQuery = query.split("WHERE");
        val selectQuery = splitQuery[0]

        if (selectQuery.contains("SELECT *")) {
            student.id = rs.getLong("id")
            student.name = rs.getString("name")
            student.age = rs.getInt("age")
            return student
        }

        if (selectQuery.contains("id")) student.id = rs.getLong("id")
        if (selectQuery.contains("name")) student.name = rs.getString("name")
        if (selectQuery.contains("age")) student.age = rs.getInt("age")
        return student
    }

    fun mockStudents(): List<Student> {
        val students = mutableListOf<Student>()

        val student1 = Student()
        student1.name = "Peter"
        student1.age = 12

        val student2 = Student()
        student2.name = "Alan"
        student2.age = 12

        val student3 = Student()
        student3.name = "Kornel"
        student3.age = 12

        students.add(student1)
        students.add(student2)
        students.add(student3)

        return students
    }
}