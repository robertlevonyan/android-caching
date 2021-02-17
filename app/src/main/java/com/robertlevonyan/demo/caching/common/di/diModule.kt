package com.robertlevonyan.demo.caching.common.di

import com.robertlevonyan.demo.caching.common.network.ApiService
import com.robertlevonyan.demo.caching.common.network.RetrofitClient
import com.robertlevonyan.demo.caching.common.repository.*
import com.robertlevonyan.demo.caching.common.view.MainViewModel
import com.robertlevonyan.demo.caching.common.view.dropboxstore.DropBoxStoreViewModel
import com.robertlevonyan.demo.caching.common.view.objectbox.ObjectBoxViewModel
import com.robertlevonyan.demo.caching.common.view.realm.RealmViewModel
import com.robertlevonyan.demo.caching.common.view.room.RoomViewModel
import com.robertlevonyan.demo.caching.common.view.sqldelight.SqlDelightViewModel
import com.robertlevonyan.demo.caching.room.AppDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val diModule = module {
  // retrofit
  single<ApiService> { RetrofitClient.getClient().create(ApiService::class.java) }

  // room
  single { AppDatabase.getInstance(get()) }

  single { get<AppDatabase>().movieDao() }

  // repositories
  single { MovieRepository(get()) }

  single { DropBoxStoreRepository() }

  single { ObjectBoxRepository() }

  single { RealmRepository() }

  single { RoomRepository(get()) }

  single { SqlDelightRepository() }

  // view model
  viewModel { MainViewModel(get(), get(), get(), get(), get(), get()) }

  viewModel { DropBoxStoreViewModel(get()) }

  viewModel { ObjectBoxViewModel(get()) }

  viewModel { RealmViewModel(get()) }

  viewModel { RoomViewModel(get()) }

  viewModel { SqlDelightViewModel(get()) }
}