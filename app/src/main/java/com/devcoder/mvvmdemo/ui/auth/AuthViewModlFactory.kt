package com.devcoder.mvvmdemo.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devcoder.mvvmdemo.data.repository.UserRepository

class AuthViewModlFactory(private val userRepository: UserRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(userRepository = userRepository) as T
    }
}