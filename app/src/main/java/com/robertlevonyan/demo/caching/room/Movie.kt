package com.robertlevonyan.demo.caching.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.*
import com.robertlevonyan.demo.caching.common.network.Movie as ApiMovie

@Entity
data class Movie(
    @PrimaryKey
    val id: Long,
    val backdropPath: String,
    val posterPath: String,
    val title: String,
    val overview: String,
    @TypeConverters(DateTypeConverter::class)
    val releaseDate: Date,
)

fun ApiMovie.toRoomMovie(): Movie = Movie(id, backdropPath, posterPath, title, overview, releaseDate)

fun Movie.toMovie(): ApiMovie = ApiMovie(id, backdropPath, posterPath, title, overview, releaseDate)
