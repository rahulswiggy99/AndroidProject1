package com.example.application2.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(URL.url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api:API by lazy{
        retrofit.create(API::class.java)
    }
}