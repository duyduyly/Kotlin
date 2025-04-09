package com.alan.login.services

import com.alan.login.Utils.UserUtils
import com.alan.login.models.dtos.UserDto
import com.alan.login.models.entity.User
import com.alan.login.repository.UserRepository
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
@Slf4j
class UserService(
    val userRepository : UserRepository,
    val userUtils : UserUtils
) {

    val log = LoggerFactory.getLogger(UserService::class.java)

    fun create(userDto: UserDto): Unit {
        val generateSalt = userUtils.generateSalt(16)
        val user = User()
        user.username = userDto.username
        user.salt = generateSalt
        user.password = this.passwordEncrypt(password = userDto.password, salt = generateSalt)
        userRepository.save(user)
        log.info("Created user ${user.username} successfully")
    }

    private fun passwordEncrypt(password: String, salt: String): String {
        if(Objects.isNull(password) ||password.isBlank() || password.isEmpty()) this.throwException("Password cannot be empty")
       return salt + Base64.getEncoder().encodeToString(password.toByteArray())
    }

    private fun throwException(msg: String): Nothing {
        throw Exception(msg)
    }
}