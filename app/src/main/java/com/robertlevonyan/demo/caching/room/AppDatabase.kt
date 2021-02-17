package com.robertlevonyan.demo.caching.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [RoomMovie::class], version = 2)
@TypeConverters(value = [DateTypeConverter::class])
abstract class AppDatabase : RoomDatabase() {
  abstract fun movieDao(): MovieDao

  companion object {
    @Volatile
    private var instance: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase =
        instance ?: synchronized(this) {
          instance ?: buildDatabase(context).also { instance = it }
        }

    private fun buildDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "MoviewDb")
            .fallbackToDestructiveMigration()
            .build()
  }
}