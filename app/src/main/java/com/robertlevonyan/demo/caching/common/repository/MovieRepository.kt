package com.robertlevonyan.demo.caching.common.repository

import com.robertlevonyan.demo.caching.common.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val apiService: ApiService) {
  suspend fun getMovies() = withContext(Dispatchers.IO) {
    apiService.getMovies("Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3ZjAwZWM2Y2UyNjRhOTA4MjBkMTc5ZjZhMDRmOTVmNCIsInN1YiI6IjVhZjU4ODYxYzNhMzY4MmE4NDAwNWFhMyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.NQXqWyJqpVu5WYc-zKaGAQW5E30gNFkoMhzPFox6Rko").let {
      it.movies
    }
  }
}
