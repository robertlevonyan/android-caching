package com.robertlevonyan.demo.caching.common.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robertlevonyan.demo.caching.common.network.Movie
import com.robertlevonyan.demo.caching.common.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

  val allMovies = MutableStateFlow<List<Movie>>(emptyList())

  init {
    viewModelScope.launch {
      val movies = movieRepository.getMovies()
      allMovies.value = movies
    }
  }
}