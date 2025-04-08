package com.alan.login.Utils

import org.springframework.stereotype.Component
import java.security.SecureRandom
import java.util.Base64

@Component
class UserUtils {
    fun generateSalt(length: Int = 16): String {
        val random = SecureRandom()
        val salt = ByteArray(length)
        random.nextBytes(salt)
        return Base64.getEncoder().encodeToString(salt)
    }
}