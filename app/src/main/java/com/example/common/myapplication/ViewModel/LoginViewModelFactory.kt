package com.example.common.myapplication.ViewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.common.myapplication.Interface.LoginResultCallBacks

class LoginViewModelFactory(private val listener:LoginResultCallBacks): ViewModelProvider.NewInstanceFactory() {
    override fun<T:ViewModel?> create (modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}