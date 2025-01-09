package com.learn.signupfirebase.data


import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<FirebaseUser>
    suspend fun signUp(
        name: String,
        email: String,
        password: String,
        celphone: String
    ): Resource<FirebaseUser>
    fun logout()
    val currentUser:FirebaseUser?//pode receber valores nulos

}
