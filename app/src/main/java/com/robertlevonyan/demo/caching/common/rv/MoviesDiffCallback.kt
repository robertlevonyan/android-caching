package com.robertlevonyan.demo.caching.common.rv

import androidx.recyclerview.widget.DiffUtil
import com.robertlevonyan.demo.caching.common.network.Movie

class MoviesDiffCallback : DiffUtil.ItemCallback<Movie>() {
  override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem.id == newItem.id

  override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem == newItem
}
