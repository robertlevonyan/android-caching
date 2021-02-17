package com.robertlevonyan.demo.caching.common.repository

import com.robertlevonyan.demo.caching.common.network.Movie
import com.robertlevonyan.demo.caching.realm.RealmMovie
import com.robertlevonyan.demo.caching.realm.toMovie
import io.realm.Realm
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

@Suppress("EXPERIMENTAL_API_USAGE")
class RealmRepository(private val realm: Realm) : DbRepository {
  override suspend fun save(movies: List<Movie>) {
    realm.executeTransactionAwait { r ->
      for (movie in movies) {
        if (r.where(RealmMovie::class.java).equalTo("id", movie.id).findFirst() != null) {
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

  suspend fun getMovies(): Flow<List<Movie>> = callbackFlow {
    realm.executeTransactionAwait { r ->
      val movies = r.where(RealmMovie::class.java).findAll()
      offer(movies.map { it.toMovie() })
//      movies?.addChangeListener { result ->
//        if (result.size != movies.size) {
//          offer(result.map { it.toMovie() })
//        }
//      }
    }

    awaitClose { println("End Realm") }
  }
}
