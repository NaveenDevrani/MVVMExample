package com.devcoder.mvvmdemo.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.devcoder.mvvmdemo.data.network.ApiService
import com.devcoder.mvvmdemo.data.network.NetworkConnectionInterceptor
import com.devcoder.mvvmdemo.data.network.SafeApiRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(
    private val apiService: ApiService,
    private val networkConnectionInterceptor: NetworkConnectionInterceptor
) : SafeApiRequest() {

    fun userLogin(email: String, password: String): LiveData<String> {
        val loginResponse = MutableLiveData<String>()
        ApiService(networkConnectionInterceptor).userLogin(email, password)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        loginResponse.value = response.body()?.toString()
                    } else {
                        loginResponse.value = response.errorBody()?.toString()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value = t.message
                }
            })
        return loginResponse
    }

    suspend fun userLogins(email: String, password: String): String {
        return apiRequest { apiService.userLogins(email, password) }
    }
}