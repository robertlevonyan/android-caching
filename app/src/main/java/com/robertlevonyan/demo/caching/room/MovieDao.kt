package com.robertlevonyan.demo.caching.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun saveMovies(vararg movies: RoomMovie): List<Long>

  @Query("SELECT * FROM RoomMovie")
  fun getMovies(): Flow<List<RoomMovie>>
}
