package com.robertlevonyan.demo.caching.common.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
  private var retrofit: Retrofit? = null

  fun getClient(): Retrofit = retrofit ?: Retrofit.Builder().run {
    baseUrl("https://api.themoviedb.org/3/")
    addConverterFactory(GsonConverterFactory.create())
    client(getOkHttpClient())
    build().also { retrofit = it }
  }

  private fun getOkHttpClient(): OkHttpClient = OkHttpClient.Builder().run {
    addInterceptor(HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    })
    build()
  }
}