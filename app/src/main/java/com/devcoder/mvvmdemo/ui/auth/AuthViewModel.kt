package com.devcoder.mvvmdemo.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.devcoder.mvvmdemo.data.repository.UserRepository
import com.devcoder.mvvmdemo.util.ApiException
import com.devcoder.mvvmdemo.util.Corutines
import com.devcoder.mvvmdemo.util.NoInternetException

class AuthViewModel(private val userRepository: UserRepository) : ViewModel() {

    var email: String? = null
    var password: String? = null
    var authListener: AuthInterface? = null


    fun loginButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("email and password is empty")
            return
        } else {
//
//            val loginResponse = UserRepository().userLogin(email!!, password!!)
//            authListener?.onSuccess(loginResponse)
            Corutines.main {
                try {
                    val response = userRepository.userLogins(email!!, password!!)
                    authListener?.onSuccesss(response!!)
//                if (response.isSuccessful) {
//                    authListener?.onSuccesss(response.body()!!)
//                } else {
//                    authListener?.onFailure("error code: ${response.code()}")
//                }
                } catch (e: ApiException) {
                    authListener?.onFailure(e.message!!)
                } catch (e: NoInternetException) {
                    e.printStackTrace()
                    authListener?.onFailure(e.message ?: "")
                }
            }
        }
    }
}