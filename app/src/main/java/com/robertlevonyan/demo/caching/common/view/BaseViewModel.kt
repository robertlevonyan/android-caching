package com.robertlevonyan.demo.caching.common.view

import androidx.lifecycle.ViewModel
import com.robertlevonyan.demo.caching.common.network.Movie
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel : ViewModel() {
  val allMovies = MutableStateFlow<List<Movie>>(emptyList())
}