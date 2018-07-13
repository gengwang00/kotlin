package com.example.common.myapplication.View

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.common.myapplication.Interface.LoginResultCallBacks
import com.example.common.myapplication.R
import com.example.common.myapplication.ViewModel.LoginViewModel
import com.example.common.myapplication.ViewModel.LoginViewModelFactory
import com.example.common.myapplication.databinding.ActivityMainBinding
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(), LoginResultCallBacks {
    override fun onSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        binding.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this)).get(LoginViewModel::class.java)
    }
}
