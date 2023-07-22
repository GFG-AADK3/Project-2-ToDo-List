package com.example.project2_todolistapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

// 1.Entity -> Table structure -> how your data is stored
@Entity(tableName = "Notes_table")
data class Todo (
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,

    val isDone : Boolean = false,

    val title : String,

    val Desc : String,

    val date : Date
        )

