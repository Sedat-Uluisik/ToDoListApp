package com.sedat.todolistapp.database.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sedat.todolistapp.model.Title
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertTitle(title: Title): Long

   /* @Query("select * from title_table")
    suspend fun getDailyTitle(): DataSource.Factory<Int, Title>*/

    //sağlam bu kullanılacak -> https://github.com/MohamedSoliman1999/Search_Filter_Room_Paging
    // karşılaştır -> https://github.com/gouravkhunger/room-paging3-demo/tree/main/app/src/main

    @Query("select * from title_table where category = :category")
    fun getTitles(category: Int): Flow<List<Title>>

}