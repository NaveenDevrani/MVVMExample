package com.devcoder.mvvmexample.interfaces

import androidx.lifecycle.LiveData

interface AuthListener {

    fun onSuccess(loginResponse:LiveData<String>)
    fun onFailure(error:String)
    fun onStarted()
}