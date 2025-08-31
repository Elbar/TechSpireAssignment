package com.example.data.remote

import com.example.domain.constants.CONNECT_TIMEOUT_IN_SECONDS
import com.example.domain.constants.READ_TIMEOUT_IN_SECONDS
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object TechSpireApiRetrofitBuilder {
    private const val BASE_URL = "https://hr-challenge.dev.tapyou.com/"

    fun build(): TechSpireApi {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(ConnectivityInterceptor())
            addInterceptor(logging)
            connectTimeout(CONNECT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)

        }.build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build().create()
    }
}
