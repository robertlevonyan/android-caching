package com.robertlevonyan.demo.caching.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*
import com.robertlevonyan.demo.caching.common.network.Movie as ApiMovie

@Entity
data class RoomMovie(
    @PrimaryKey
    val id: Long,
    val backdropPath: String,
    val posterPath: String,
    val title: String,
    val overview: String,
    @TypeConverters(DateTypeConverter::class)
    val releaseDate: Date,
)

fun ApiMovie.toRoomMovie(): RoomMovie = RoomMovie(id, backdropPath, posterPath, title, overview, releaseDate)

fun RoomMovie.toMovie(): ApiMovie = ApiMovie(id, backdropPath, posterPath, title, overview, releaseDate)
