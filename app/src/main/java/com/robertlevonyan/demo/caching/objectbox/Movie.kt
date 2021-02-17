package com.robertlevonyan.demo.caching.objectbox

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*
import com.robertlevonyan.demo.caching.common.network.Movie as ApiMovie

@Entity
data class ObMovie(
    @Id(assignable = true)
    var id: Long,
    var backdropPath: String,
    var posterPath: String,
    var title: String,
    var overview: String,
    var releaseDate: Date,
)

fun ApiMovie.toObMovie(): ObMovie = ObMovie(id, backdropPath, posterPath, title, overview, releaseDate)

fun ObMovie.toMovie(): ApiMovie = ApiMovie(id, backdropPath, posterPath, title, overview, releaseDate)
