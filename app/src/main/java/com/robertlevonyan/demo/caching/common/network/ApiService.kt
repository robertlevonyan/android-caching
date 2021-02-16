package com.robertlevonyan.demo.caching.common.network

import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
  @GET("movie/popular")
  suspend fun getMovies(@Header("Authorization") token: String): ApiResponse
}
