package com.devcoder.mvvmexpectlevel.network

import com.devcoder.mvvmexpectlevel.model.UserAuthModelClass
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("player_api.php")
    suspend fun login(
        @Query("username") username: String?,
        @Query("password") password: String?
    ): UserAuthModelClass
}