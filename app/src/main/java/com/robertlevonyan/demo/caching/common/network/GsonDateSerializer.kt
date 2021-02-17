package com.robertlevonyan.demo.caching.common.network

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

class GsonDateSerializer : JsonSerializer<Date> {
    companion object {
        private val DATE_ISO_8601_2004 = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    }

    override fun serialize(src: Date?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? {
        return try {
            JsonPrimitive(DATE_ISO_8601_2004.format(src))
        } catch (e: Throwable) {
            null
        }
    }
}
