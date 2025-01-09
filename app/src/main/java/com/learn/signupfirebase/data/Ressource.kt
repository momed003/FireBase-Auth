package com.learn.signupfirebase.data

sealed class Resource <out R>{
    data class Sucess <out R>(val result:R): Resource<R>()
    data class Error (val exception : Exception): Resource<Nothing>()
    object Loading: Resource<Nothing>()
}