package com.sedat.todolistapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.sedat.todolistapp.model.Title

@Dao
interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertTitle(title: Title): Long

}