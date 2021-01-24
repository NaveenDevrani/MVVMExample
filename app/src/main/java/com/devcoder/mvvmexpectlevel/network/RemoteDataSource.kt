package com.devcoder.mvvmexpectlevel.network

import com.devcoder.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource {

    companion object {
        private const val BASE_URL = "http://iptv.appino.tv:80/"
    }

    fun <Api> buildApi(api: Class<Api>): Api {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().also {
                if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    it.addInterceptor(logging)
                }
            }.build())
            .addConverterFactory(GsonConverterFactory.create()).build().create(api)
    }
}