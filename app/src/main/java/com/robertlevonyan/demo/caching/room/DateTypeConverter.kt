package com.robertlevonyan.demo.caching.room

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class DateTypeConverter {
  companion object {
    private val format = SimpleDateFormat("yyyy-MM-dd", Locale.US)
  }

  @TypeConverter
  fun fromStringToDate(value: String?): Date? {
    return try {
      synchronized(format) {
        format.parse(value.orEmpty())
      }
    } catch (e: Throwable) {
      null
    }
  }

  @TypeConverter
  fun toDateFromString(value: Date?): String? = value?.let {
    synchronized(format) {
      format.format(value)
    }
  }
}