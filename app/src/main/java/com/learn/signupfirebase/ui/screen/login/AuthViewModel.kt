package com.learn.signupfirebase.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.learn.signupfirebase.data.AuthRepository
import com.learn.signupfirebase.data.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository

) : ViewModel() {

    private val _loginFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Resource<FirebaseUser>?> = _loginFlow

    private val _signUpFlow = MutableStateFlow<Resource<FirebaseUser>?>(null)
    val signUpFlow: StateFlow<Resource<FirebaseUser>?> = _signUpFlow

    val currentUser:FirebaseUser?
        get()= repository.currentUser

    init {
        if (repository.currentUser != null){
            _loginFlow.value=Resource.Sucess(repository.currentUser!!)
        }
    }

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginFlow.value = Resource.Loading
        val result = repository.login(email, password)
        _loginFlow.value = result
    }

    fun signUp(name: String, email: String, password: String, cellphone: String) =
        viewModelScope.launch {
            _signUpFlow.value = Resource.Loading
            val result = repository.signUp(name, email, password, cellphone)
            _signUpFlow.value = result
        }

    fun logout() {
        repository.logout()
        _loginFlow.value = null
        _signUpFlow.value = null
    }

}