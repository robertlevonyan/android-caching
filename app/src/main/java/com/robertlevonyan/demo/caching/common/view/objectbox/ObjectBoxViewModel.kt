package com.robertlevonyan.demo.caching.common.view.objectbox

import androidx.lifecycle.viewModelScope
import com.robertlevonyan.demo.caching.common.repository.ObjectBoxRepository
import com.robertlevonyan.demo.caching.common.view.BaseViewModel
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch

class ObjectBoxViewModel(private val repository: ObjectBoxRepository) : BaseViewModel() {
  init {
    viewModelScope.launch {
      val movies = repository.getMovies()
      allMovies.emitAll(movies)
    }
  }
}
