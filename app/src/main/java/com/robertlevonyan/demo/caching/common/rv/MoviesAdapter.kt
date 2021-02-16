package com.robertlevonyan.demo.caching.common.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.robertlevonyan.demo.caching.R
import com.robertlevonyan.demo.caching.common.network.Movie
import com.robertlevonyan.demo.caching.databinding.ItemMovieBinding

class MoviesAdapter : ListAdapter<Movie, MoviesAdapter.MoviesViewHolder>(MoviesDiffCallback()) {
  class MoviesViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Movie) = binding.run {
      ivPoster.load("https://image.tmdb.org/t/p/original${item.posterPath}") {
        placeholder(R.drawable.il_placeholder)
        scale(Scale.FILL)
      }
      tvTitle.text = item.title
      tvDescription.text = item.overview
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =
      MoviesViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))

  override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
    holder.bind(getItem(position))
  }
}
