package org.example.security

fun generateToken(): String {
    return generateRandomText(20)
}

//code from ChatGPT
fun generateRandomText(length: Int): String {
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    return (1..length)
        .map { chars.random() }
        .joinToString("")
}
