package com.robertlevonyan.demo.caching.common.view

import android.app.Application
import com.robertlevonyan.demo.caching.common.di.diModule
import io.realm.Realm
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidContext(this@App)
      modules(diModule)
    }
    // realm
    Realm.init(this)
  }
}