package com.robertlevonyan.demo.caching.room

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class DateTypeConverter {
  companion object {
    private val format = SimpleDateFormat("yyyy-MM-dd", Locale.US)
  }

  @TypeConverter
  fun fromStringToDate(value: String?): Date? = format.parse(value.orEmpty())

  @TypeConverter
  fun toDateFromString(value: Date?): String? = format.format(value ?: Date())
}