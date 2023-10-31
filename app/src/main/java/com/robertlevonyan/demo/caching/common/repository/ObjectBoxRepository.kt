package com.robertlevonyan.demo.caching.common.repository

import com.robertlevonyan.demo.caching.common.network.Movie
import com.robertlevonyan.demo.caching.objectbox.ObMovie
import com.robertlevonyan.demo.caching.objectbox.toMovie
import com.robertlevonyan.demo.caching.objectbox.toObMovie
import io.objectbox.Box
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

@Suppress("EXPERIMENTAL_API_USAGE")
class ObjectBoxRepository(private val moviesBox: Box<ObMovie>) : DbRepository {
  override suspend fun save(movies: List<Movie>) {
    for (movie in movies) {
      if (moviesBox.contains(movie.id)) continue
      moviesBox.put(movie.toObMovie())
    }
  }

  override fun getMovies(): Flow<List<Movie>> = callbackFlow {
    val subscription = moviesBox.query().build().subscribe()
        .observer { data -> trySend(data.map { it.toMovie() }) }
    awaitClose { subscription.cancel() }
  }
}
