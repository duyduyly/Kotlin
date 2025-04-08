package com.alan.login.controller

import com.alan.login.models.dtos.UserDto
import com.alan.login.models.entity.User
import com.alan.login.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(var userService: UserService) {

    @GetMapping("/hello")
    fun helloApi(): String{
       return "hello world"
    }


    @PostMapping("/create")
    fun createUser(@RequestBody user: UserDto): String? {

        userService.create(user)
        return user.username;
    }
}