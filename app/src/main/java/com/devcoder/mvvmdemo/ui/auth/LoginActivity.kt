package com.devcoder.mvvmdemo.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.devcoder.R
import com.devcoder.databinding.ActivityLoginBinding
import com.devcoder.mvvmdemo.util.hide
import com.devcoder.mvvmdemo.util.show
import com.devcoder.mvvmdemo.util.snackBar
import com.devcoder.mvvmdemo.util.toast
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthInterface, KodeinAware {
    var binding: ActivityLoginBinding? = null
    override val kodein: Kodein by kodein()
    private val factory: AuthViewModlFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val networkOnMainThreadException=NetworkConnectionInterceptor(this)
//
//        val apiService = ApiService(networkOnMainThreadException)
//        val repository = UserRepository(apiService)
//        val factory = AuthViewModlFactory(repository)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)
        binding?.viewModel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        binding?.progressBar?.show()
        toast("Login started")

    }

    override fun onSuccess(loginResponse: LiveData<String>) {
//        toast("Login success")
        loginResponse.observe(this, Observer {
            binding?.progressBar?.hide()
            toast(it)
        })
    }

    override fun onSuccesss(value: String) {
//        toast("Login success $value")
    }

    override fun onFailure(error: String) {
//        toast("Login Failure")
        binding?.progressBar?.hide()
        binding?.rootLayout?.snackBar(error)
    }
}