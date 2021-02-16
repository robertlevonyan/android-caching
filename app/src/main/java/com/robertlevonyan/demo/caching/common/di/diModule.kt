package com.robertlevonyan.demo.caching.common.di

import com.robertlevonyan.demo.caching.common.network.ApiService
import com.robertlevonyan.demo.caching.common.network.RetrofitClient
import com.robertlevonyan.demo.caching.common.repository.MovieRepository
import com.robertlevonyan.demo.caching.common.view.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val diModule = module {
//  single { AppDatabase.getInstance(get()) }

  single<ApiService> { RetrofitClient.getClient().create(ApiService::class.java) }

  single { MovieRepository(get()) }

  viewModel { MainViewModel(get()) }
}