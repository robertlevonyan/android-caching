package com.robertlevonyan.demo.caching.common.view.dropboxstore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.robertlevonyan.demo.caching.common.rv.MoviesAdapter
import com.robertlevonyan.demo.caching.databinding.FragmentDropBoxStoreBinding
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class DropBoxStoreFragment : Fragment() {
  companion object {
    fun newInstance() = DropBoxStoreFragment()
  }

  private val viewModel: DropBoxStoreViewModel by viewModel()
  private val binding by lazy { FragmentDropBoxStoreBinding.inflate(layoutInflater) }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = binding.root

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    lifecycleScope.launchWhenCreated {
      val adapter = MoviesAdapter()
      binding.rvMovies.adapter = adapter
      viewModel.allMovies.collect { adapter.apply { submitList(it) } }
    }
  }
}
