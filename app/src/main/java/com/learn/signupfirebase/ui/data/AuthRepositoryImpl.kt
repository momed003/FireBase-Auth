package com.learn.signupfirebase.ui.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.learn.signupfirebase.ui.data.utils.await

class AuthRepositoryImpl(
    private val firebaseAuth: FirebaseAuth
) :
    AuthRepository {
    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Sucess(result.user!!)
        } catch (e: Exception) {
            Resource.Error(e)
        }

    }

    override suspend fun signUp(
        name: String,
        email: String,
        password: String,
        celphone: String
    ): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            Resource.Sucess(result.user!!)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    override fun logout() {
        TODO("Not yet implemented")
    }

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser
}