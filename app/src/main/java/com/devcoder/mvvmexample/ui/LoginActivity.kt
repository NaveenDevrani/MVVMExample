package com.devcoder.mvvmexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.devcoder.mvvmexample.R
import com.devcoder.mvvmexample.auth.AuthViewModel
import com.devcoder.mvvmexample.databinding.ActivityLoginBinding
import com.devcoder.mvvmexample.interfaces.AuthListener
import com.devcoder.mvvmexample.utils.hide
import com.devcoder.mvvmexample.utils.show
import com.devcoder.mvvmexample.utils.showToast
import kotlinx.android.synthetic.main.activity_login.*

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

    override fun onSuccess(loginResponse: LiveData<String>) {

        showToast(this@LoginActivity, "Login Success")
        loginResponse.observe(this, Observer {
            progress_bar.show()
            showToast(this,""+it.toString())
        })
    }

    override fun onFailure(error:String) {
        progress_bar.hide()
        showToast(this@LoginActivity, "Login Failure")
    }

    override fun onStarted() {
        progress_bar.show()
        showToast(this@LoginActivity, "Login Started")
    }
}
