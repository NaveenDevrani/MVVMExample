package com.devcoder.mvvmexpectlevel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcoder.mvvmexpectlevel.model.UserAuthModelClass
import com.devcoder.mvvmexpectlevel.network.Resource
import com.devcoder.mvvmexpectlevel.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {
    val _loginResponse: MutableLiveData<Resource<UserAuthModelClass>> = MutableLiveData()
    val loginResponse: LiveData<Resource<UserAuthModelClass>>
        get() = _loginResponse

    fun login(username: String, password: String) {
        viewModelScope.launch {
            _loginResponse.value = repository.login(username, password)
        }
    }
}