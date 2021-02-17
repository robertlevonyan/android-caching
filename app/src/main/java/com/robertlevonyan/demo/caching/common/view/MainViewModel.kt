package com.robertlevonyan.demo.caching.common.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robertlevonyan.demo.caching.common.network.Movie
import com.robertlevonyan.demo.caching.common.repository.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val movieRepository: MovieRepository,
    private val dropBoxStoreRepository: DropBoxStoreRepository,
    private val objectBoxRepository: ObjectBoxRepository,
    private val realmRepository: RealmRepository,
    private val roomRepository: RoomRepository,
    private val sqlDelightRepository: SqlDelightRepository,
) : ViewModel() {

  fun getData() {
    viewModelScope.launch {
      val movies = movieRepository.getMovies()
      dropBoxStoreRepository.save(movies)
      objectBoxRepository.save(movies)
      realmRepository.save(movies)
      roomRepository.save(movies)
      sqlDelightRepository.save(movies)
    }
  }
}