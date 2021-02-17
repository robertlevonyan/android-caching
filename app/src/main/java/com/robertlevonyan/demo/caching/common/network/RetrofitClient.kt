package com.robertlevonyan.demo.caching.common.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitClient {
  private var retrofit: Retrofit? = null

  fun getClient(): Retrofit = retrofit ?: Retrofit.Builder().run {
    baseUrl("https://api.themoviedb.org/3/")
    addConverterFactory(GsonConverterFactory.create(getGson()))
    client(getOkHttpClient())
    build().also { retrofit = it }
  }

  private fun getGson(): Gson = GsonBuilder()
      .registerTypeAdapter(Date::class.java, GsonDateDeserializer())
      .registerTypeAdapter(Date::class.java, GsonDateSerializer())
      .serializeNulls()
      .create()

  private fun getOkHttpClient(): OkHttpClient = OkHttpClient.Builder().run {
    addInterceptor(HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    })
    build()
  }
}
