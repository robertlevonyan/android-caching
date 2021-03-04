package com.robertlevonyan.demo.caching.common.repository

import com.robertlevonyan.demo.caching.common.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val apiService: ApiService) {
  suspend fun getMovies() = withContext(Dispatchers.IO) {
    apiService.getMovies("Bearer <token>").let {
      it.movies
    }
  }
}
