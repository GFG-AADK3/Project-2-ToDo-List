package com.example.project2_todolistapp.db

import androidx.room.TypeConverter
import java.sql.Timestamp
import java.util.Date

class DateConverter {
//    to convert date to long -> push into db
    @TypeConverter
    fun FromDateToLong(date: Date): Long {
        return date.time
    }

//    to convert long to date -> reading data from db

    @TypeConverter
    fun FromLongToDate(timestamp: Long): Date {
        return Date(timestamp)
    }
}