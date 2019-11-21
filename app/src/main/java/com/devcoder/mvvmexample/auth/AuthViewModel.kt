package com.devcoder.mvvmexample.auth

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import com.devcoder.mvvmexample.data.repositries.UserRepository
import com.devcoder.mvvmexample.interfaces.AuthListener
import com.devcoder.mvvmexample.utils.ApiException
import com.devcoder.mvvmexample.utils.NoInternetException

class AuthViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null
    var authListener: AuthListener? = null
    var mContext: Context? = null

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invaild email or password")
            return
        }

        val loginResponse= UserRepository().userlogin(email!!,password!!)
        // handle success
        authListener?.onSuccess(loginResponse)
    }

}