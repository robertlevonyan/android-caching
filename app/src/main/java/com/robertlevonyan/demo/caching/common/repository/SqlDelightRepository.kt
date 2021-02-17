package com.robertlevonyan.demo.caching.common.repository

import com.robertlevonyan.demo.caching.common.network.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class SqlDelightRepository : DbRepository {
  override suspend fun save(movies: List<Movie>) {
  }

  fun getMovies(): Flow<List<Movie>> = emptyFlow()
}