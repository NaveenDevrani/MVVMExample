package com.devcoder.mvvmexpectlevel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devcoder.mvvmexpectlevel.repository.BaseRepository
import com.devcoder.mvvmexpectlevel.repository.LoginRepository
import com.devcoder.mvvmexpectlevel.ui.LoginViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository as LoginRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass not found")
        }
    }
}
