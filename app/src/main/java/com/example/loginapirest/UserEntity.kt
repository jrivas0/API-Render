package com.example.loginapirest

data class UserEntity(
    var id: Long = 0,
    var email: String = "",
    var first_name:String = "",
    var last_name:String = "",
    var avatar:String = ""

)
