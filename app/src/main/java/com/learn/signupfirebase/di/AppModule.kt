package com.learn.signupfirebase.di

import com.google.firebase.auth.FirebaseAuth
import com.learn.signupfirebase.data.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn
class AppModule {

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideAuthRepository(impl: AuthRepositoryImpl):AuthRepositoryImpl=impl



}