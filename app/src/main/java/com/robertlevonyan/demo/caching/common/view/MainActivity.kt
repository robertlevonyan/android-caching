package com.robertlevonyan.demo.caching.common.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.robertlevonyan.demo.caching.common.rv.MoviesAdapter
import com.robertlevonyan.demo.caching.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
  private val viewModel: MainViewModel by viewModel()
  private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    val adapter = MoviesAdapter()
    binding.rvMovies.adapter = adapter
    binding.rvMovies.layoutManager = GridLayoutManager(this, 2)

    lifecycleScope.launchWhenCreated {
      viewModel.allMovies.collect {
        adapter.submitList(it)
      }
    }
  }
}
