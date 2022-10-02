package com.sedat.todolistapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "title_table")
data class Title(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val Id: Int,
    @ColumnInfo(name = "title")
    val titleText: String,
//    val nextToDo: String ?= null,
//    val nextToDoTime: Long ?= null,
//    val totalToDo: Int ?= null,
//    val numberOfToDoMade: Int ?= null
    )
