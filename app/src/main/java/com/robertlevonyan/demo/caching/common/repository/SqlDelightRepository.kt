package com.robertlevonyan.demo.caching.common.repository

import com.robertlevonyan.demo.caching.common.network.Movie
import com.robertlevonyan.demo.caching.sqldelight.MoviesQueries
import com.robertlevonyan.demo.caching.sqldelight.SqldMovie
import com.squareup.sqldelight.runtime.coroutines.asFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*

class SqlDelightRepository(private val queries: MoviesQueries) : DbRepository {
  override suspend fun save(movies: List<Movie>) {
    movies.forEach { movie ->
      queries.insert(SqldMovie(movie.id, movie.backdropPath, movie.posterPath, movie.title, movie.overview, movie.releaseDate))
    }
  }

  override fun getMovies(): Flow<List<Movie>> = queries.selectAll()
      .asFlow()
      .map { query ->
        query.executeAsList().map { movie ->
          Movie(
              id = movie.id,
              backdropPath = movie.backdropPath.orEmpty(),
              posterPath = movie.posterPath.orEmpty(),
              title = movie.title.orEmpty(),
              overview = movie.overview.orEmpty(),
              releaseDate = movie.releaseDate ?: Date(),
          )
        }
      }
}
