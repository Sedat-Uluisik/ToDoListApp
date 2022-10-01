package com.sedat.todolistapp.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sedat.todolistapp.database.dao.ToDoDao
import com.sedat.todolistapp.model.Title

@Database(entities = [Title::class], version = 1)
abstract class ToDoDatabase: RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}