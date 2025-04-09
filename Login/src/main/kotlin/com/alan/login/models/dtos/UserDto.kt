package com.alan.login.models.dtos

import com.fasterxml.jackson.annotation.JsonProperty

class UserDto {

    @JsonProperty(value = "username")
     var username: String = ""
        get() {return field ?: ""}
        set(value) {field = value;}

    @JsonProperty(value = "password")
     var password: String =  ""
        get() {return field ?: ""}
        set(value) {field = value;}

}