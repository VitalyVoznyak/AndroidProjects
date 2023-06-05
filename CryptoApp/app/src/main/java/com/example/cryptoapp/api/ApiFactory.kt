package com.example.cryptoapp.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val baseUrl: String = "https://min-api.cryptocompare.com/data/"
    const val BASE_IMAGE_URL: String = "https://min-api.cryptocompare.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .baseUrl(baseUrl)
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}