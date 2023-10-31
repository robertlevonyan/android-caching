package com.robertlevonyan.demo.caching.common.di

import com.robertlevonyan.demo.caching.Database
import com.robertlevonyan.demo.caching.common.network.ApiService
import com.robertlevonyan.demo.caching.common.network.RetrofitClient
import com.robertlevonyan.demo.caching.common.repository.*
import com.robertlevonyan.demo.caching.common.view.MainViewModel
import com.robertlevonyan.demo.caching.common.view.objectbox.ObjectBoxViewModel
import com.robertlevonyan.demo.caching.common.view.realm.RealmViewModel
import com.robertlevonyan.demo.caching.common.view.room.RoomViewModel
import com.robertlevonyan.demo.caching.common.view.sqldelight.SqlDelightViewModel
import com.robertlevonyan.demo.caching.objectbox.ObMovie
import com.robertlevonyan.demo.caching.objectbox.ObjectBox
import com.robertlevonyan.demo.caching.room.AppDatabase
import com.robertlevonyan.demo.caching.sqldelight.DateAdapter
import com.robertlevonyan.demo.caching.sqldelight.SqldMovie
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import io.realm.Realm
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val diModule = module {
  // retrofit
  single<ApiService> { RetrofitClient.getClient().create(ApiService::class.java) }

  // object box
  single { ObjectBox.boxStore.boxFor(ObMovie::class.java) }

  // realm
  single { Realm.getDefaultInstance() }

  // room
  single { AppDatabase.getInstance(get()) }

  single { get<AppDatabase>().movieDao() }

  // sql delight
  single<SqlDriver> { AndroidSqliteDriver(schema = Database.Schema, context = androidContext(), name = "caching.db") }

  single { Database(get(), SqldMovie.Adapter(DateAdapter())) }

  single { get<Database>().moviesQueries }

  // repositories
  single { MovieRepository(get()) }

  single { ObjectBoxRepository(get()) }

  single { RealmRepository(get()) }

  single { RoomRepository(get()) }

  single { SqlDelightRepository(get()) }

  // view model
  viewModel { MainViewModel(get(), get(), get(), get(), get()) }

  viewModel { ObjectBoxViewModel(get()) }

  viewModel { RealmViewModel(get()) }

  viewModel { RoomViewModel(get()) }

  viewModel { SqlDelightViewModel(get()) }
}