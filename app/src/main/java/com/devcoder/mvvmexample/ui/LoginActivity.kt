package com.devcoder.mvvmexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.devcoder.mvvmexample.R
import com.devcoder.mvvmexample.auth.AuthViewModel
import com.devcoder.mvvmexample.databinding.ActivityLoginBinding
import com.devcoder.mvvmexample.interfaces.AuthListener
import com.devcoder.mvvmexample.utils.showToast

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this
        viewModel.mContext=this
    }

    override fun onSuccess() {
        showToast(this@LoginActivity, "Login Success")

    }

    override fun onFailure(error:String) {
        showToast(this@LoginActivity, "Login Failure")
    }

    override fun onStarted() {
        showToast(this@LoginActivity, "Login Started")
    }

}
