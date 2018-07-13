package com.example.common.myapplication.Model

import android.databinding.BaseObservable

class User(private var email: String, private  var password: String) : BaseObservable() {
    val isDataValid:Boolean
    get() = getPassword().length > 2 && getEmail().length > 2

    fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getEmail(): String {
        return email
    }

    fun setEmail(email : String) {
        this.email = email
    }

}