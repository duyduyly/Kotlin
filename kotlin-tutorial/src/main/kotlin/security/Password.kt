package org.example.security

fun encryptPass(password: String): String {
    return password + (1..200).random().toString()
}
