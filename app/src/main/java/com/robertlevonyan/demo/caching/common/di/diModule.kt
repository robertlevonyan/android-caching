package com.robertlevonyan.demo.caching.common.di

import com.robertlevonyan.demo.caching.common.network.ApiService
import com.robertlevonyan.demo.caching.common.network.RetrofitClient
import com.robertlevonyan.demo.caching.common.repository.*
import com.robertlevonyan.demo.caching.common.view.MainViewModel
import com.robertlevonyan.demo.caching.common.view.objectbox.ObjectBoxViewModel
import com.robertlevonyan.demo.caching.common.view.realm.RealmViewModel
import com.robertlevonyan.demo.caching.common.view.room.RoomViewModel
import com.robertlevonyan.demo.caching.common.view.sqldelight.SqlDelightViewModel
import com.robertlevonyan.demo.caching.room.AppDatabase
import io.realm.Realm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val diModule = module {
  // retrofit
  single<ApiService> { RetrofitClient.getClient().create(ApiService::class.java) }

  // realm

  single { Realm.getDefaultInstance() }

  // room
  single { AppDatabase.getInstance(get()) }

  single { get<AppDatabase>().movieDao() }

  // repositories
  single { MovieRepository(get()) }

  single { ObjectBoxRepository() }

  single { RealmRepository(get()) }

  single { RoomRepository(get()) }

  single { SqlDelightRepository() }

  // view model
  viewModel { MainViewModel(get(), get(), get(), get(), get()) }

  viewModel { ObjectBoxViewModel(get()) }

  viewModel { RealmViewModel(get()) }

  viewModel { RoomViewModel(get()) }

  viewModel { SqlDelightViewModel(get()) }
}