package com.devcoder.mvvmdemo.ui.auth

import androidx.lifecycle.LiveData

interface AuthInterface {
    fun onStarted()
    fun onSuccess(loginResponse: LiveData<String>)
    fun onSuccesss(value: String)
    fun onFailure(error: String)
}