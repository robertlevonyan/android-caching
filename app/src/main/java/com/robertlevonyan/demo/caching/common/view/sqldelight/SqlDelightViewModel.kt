package com.robertlevonyan.demo.caching.common.view.sqldelight

import androidx.lifecycle.viewModelScope
import com.robertlevonyan.demo.caching.common.repository.SqlDelightRepository
import com.robertlevonyan.demo.caching.common.view.BaseViewModel
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch

class SqlDelightViewModel(private val repository: SqlDelightRepository) : BaseViewModel() {
  init {
    viewModelScope.launch {
      val movies = repository.getMovies()
      allMovies.emitAll(movies)
    }
  }
}