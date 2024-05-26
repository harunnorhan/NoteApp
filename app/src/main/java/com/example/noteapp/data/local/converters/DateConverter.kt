package com.example.noteapp.data.local.converters

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    // Convert to date
    @TypeConverter
    fun toDate(date: Long?): Date? {
        return date?.let { Date(it) }
    }

    // Convert from date
    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }
}