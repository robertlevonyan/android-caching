package com.robertlevonyan.demo.caching.common.network

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class GsonDateDeserializer : JsonDeserializer<Date?> {
    companion object {
        private val DATE_ISO_8601_2004 = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    }

    @Throws(JsonParseException::class)
    override fun deserialize(element: JsonElement, arg1: Type?, arg2: JsonDeserializationContext?): Date? {
        return try {
            DATE_ISO_8601_2004.parse(element.asString)
        } catch (e: ParseException) {
            e.printStackTrace()
            null
        }
    }
}
