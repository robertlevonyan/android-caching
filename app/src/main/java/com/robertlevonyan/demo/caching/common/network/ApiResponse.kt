package com.robertlevonyan.demo.caching.common.network

import com.google.gson.annotations.SerializedName
import java.util.*

data class ApiResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>,
)

data class Movie(
    @SerializedName("id")
    val id: Long,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: Date,
)