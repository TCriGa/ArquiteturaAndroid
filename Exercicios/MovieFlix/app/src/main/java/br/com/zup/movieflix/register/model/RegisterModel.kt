package br.com.zup.movieflix.register.model

data class RegisterModel(
    var name: String,
    var password: String,
    var email : String,
    var confirmEmail : String
)