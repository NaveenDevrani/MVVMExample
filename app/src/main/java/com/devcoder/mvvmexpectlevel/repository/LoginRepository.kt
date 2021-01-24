package com.devcoder.mvvmexpectlevel.repository

import com.devcoder.mvvmexpectlevel.network.ApiService

class LoginRepository(private val api: ApiService) : BaseRepository() {
     suspend fun login(username: String, password: String) =
        safeApiCall {
            api.login(username, password)
        }
}