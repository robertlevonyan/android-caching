package com.robertlevonyan.demo.caching.sqldelight

import com.squareup.sqldelight.ColumnAdapter
import java.text.SimpleDateFormat
import java.util.*

class DateAdapter : ColumnAdapter<Date, String> {
  companion object {
    private val format = SimpleDateFormat("yyyy-MM-dd", Locale.US)
  }

  override fun decode(databaseValue: String): Date = format.parse(databaseValue) ?: Date()

  override fun encode(value: Date): String = format.format(value)
}