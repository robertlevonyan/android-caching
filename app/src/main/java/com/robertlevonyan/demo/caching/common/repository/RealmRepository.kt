package com.robertlevonyan.demo.caching.common.repository

import com.robertlevonyan.demo.caching.common.network.Movie
import com.robertlevonyan.demo.caching.realm.RealmMovie
import com.robertlevonyan.demo.caching.realm.toMovie
import io.realm.Realm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class RealmRepository(private val realm: Realm) : DbRepository {
  override suspend fun save(movies: List<Movie>) {
    realm.executeTransactionAsync { r ->
      for (movie in movies) {
        if (r.where(RealmMovie::class.java).equalTo("id", movie.id) != null) {
          continue
        }
        val realmMovie = r.createObject(RealmMovie::class.java, movie.id)
        realmMovie.backdropPath = movie.backdropPath
        realmMovie.posterPath = movie.posterPath
        realmMovie.title = movie.title
        realmMovie.overview = movie.overview
        realmMovie.releaseDate = movie.releaseDate
      }
    }
  }

  fun getMovies(onReceived: (Flow<List<Movie>>) -> Unit) {
    realm.executeTransactionAsync { r ->
      val movies = r.where(RealmMovie::class.java)
          .findAll()
          ?.toList()
          ?.map { it.toMovie() } ?: return@executeTransactionAsync

      onReceived(flowOf(movies))
    }
  }
}
