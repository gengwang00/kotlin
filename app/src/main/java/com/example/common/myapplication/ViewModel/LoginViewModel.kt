package com.example.common.myapplication.ViewModel

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.common.myapplication.Interface.LoginResultCallBacks
import com.example.common.myapplication.Model.User

class LoginViewModel(private val listener: LoginResultCallBacks) : ViewModel() {
    private val user: User

    init {
        this.user = User("", "")
    }

    val myField : ObservableField<String> = ObservableField("ccc")

    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setEmail(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        }

    val passwordtextWatcher: TextWatcher
    get() = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            user.setPassword(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    }

    fun onLoginClicked(v: View){
        if(user.isValid()) {
            listener.onSuccess("Login Success")
            myField.set("Login Success")
        }
        else
            listener.onError("Login Failed")
    }
}