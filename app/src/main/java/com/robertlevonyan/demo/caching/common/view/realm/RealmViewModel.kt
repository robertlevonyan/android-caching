package com.robertlevonyan.demo.caching.common.view.realm

import androidx.lifecycle.viewModelScope
import com.robertlevonyan.demo.caching.common.repository.RealmRepository
import com.robertlevonyan.demo.caching.common.view.BaseViewModel
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch

class RealmViewModel(repository: RealmRepository) : BaseViewModel() {
  init {
    viewModelScope.launch {
      val movies = repository.getMovies()
      allMovies.emitAll(movies)
    }
  }
}
