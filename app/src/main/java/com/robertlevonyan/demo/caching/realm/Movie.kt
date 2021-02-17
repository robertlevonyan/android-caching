package com.robertlevonyan.demo.caching.realm

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*
import com.robertlevonyan.demo.caching.common.network.Movie as ApiMovie

open class RealmMovie : RealmObject() {
    @PrimaryKey
    var id: Long = 0L
    var backdropPath: String = ""
    var posterPath: String = ""
    var title: String = ""
    var overview: String = ""
    var releaseDate: Date = Date()
}

fun RealmMovie.toMovie(): ApiMovie = ApiMovie(id, backdropPath, posterPath, title, overview, releaseDate)
