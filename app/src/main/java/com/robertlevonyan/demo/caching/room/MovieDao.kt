package com.robertlevonyan.demo.caching.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun saveMovies(vararg movies: Movie)

  @Query("SELECT * FROM Movie")
  fun getMovies(): Flow<List<Movie>>
}
