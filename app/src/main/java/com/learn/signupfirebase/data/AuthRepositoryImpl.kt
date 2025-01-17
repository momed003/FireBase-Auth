package com.learn.signupfirebase.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.learn.signupfirebase.data.utils.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
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
            result?.user?.updateProfile(UserProfileChangeRequest.Builder().setDisplayName(name).build())?.await()
            Resource.Sucess(result.user!!)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }

    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser
}