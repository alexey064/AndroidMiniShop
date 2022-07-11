package com.example.myapplication.Other

import com.google.gson.JsonDeserializer
import kotlin.Throws
import com.google.gson.JsonParseException
import com.google.gson.JsonElement
import com.google.gson.JsonDeserializationContext
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateDeserializer : JsonDeserializer<Date?> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        element: JsonElement,
        arg1: Type,
        arg2: JsonDeserializationContext
    ): Date? {
        val date = element.asString
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        format.timeZone = TimeZone.getTimeZone("GMT")
        return try {
            format.parse(date)
        } catch (exp: ParseException) {
            System.err.println(exp.message)
            null
        }
    }
}