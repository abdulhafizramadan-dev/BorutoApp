package com.ahr.borutoapp.data.local

import androidx.room.TypeConverter

class DatabaseConverter(private val separator: String = ",") {

    @TypeConverter
    fun convertListToString(list: List<String>): String {
        return list.joinToString(separator = separator)
    }

    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(",")
    }
}