package com.sedat.todolistapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "title_table")
data class Title(
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val titleText: String,
    val nextToDo: String = "",
    val nextToDoTime: Long = 0L,
    val totalToDo: Int = 0,
    val numberOfToDoMade: Int = 0
    )
