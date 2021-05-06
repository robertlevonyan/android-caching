package com.robertlevonyan.demo.caching.common.repository

import com.robertlevonyan.demo.caching.common.network.Movie
import com.robertlevonyan.demo.caching.room.MovieDao
import com.robertlevonyan.demo.caching.room.toMovie
import com.robertlevonyan.demo.caching.room.toRoomMovie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomRepository(private val movieDao: MovieDao) : DbRepository {
  override suspend fun save(movies: List<Movie>) {
    movieDao.saveMovies(*movies.map { it.toRoomMovie() }.toTypedArray())
  }

  override fun getMovies(): Flow<List<Movie>> = movieDao.getMovies().map { it.map { movie -> movie.toMovie() } }
}
