package com.devcoder.mvvmexample.interfaces

interface AuthListener {

    fun onSuccess()
    fun onFailure(error:String)
    fun onStarted()
}