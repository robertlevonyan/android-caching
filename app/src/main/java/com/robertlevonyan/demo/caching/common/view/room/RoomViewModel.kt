package com.robertlevonyan.demo.caching.common.view.room

import androidx.lifecycle.viewModelScope
import com.robertlevonyan.demo.caching.common.repository.RoomRepository
import com.robertlevonyan.demo.caching.common.view.BaseViewModel
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch

class RoomViewModel(private val repository: RoomRepository) : BaseViewModel() {
  init {
    viewModelScope.launch {
      val movies = repository.getMovies()
      allMovies.emitAll(movies)
    }
  }
}
