package com.sedat.todolistapp.data.repository

import com.sedat.todolistapp.model.Title
import com.sedat.todolistapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {
    suspend fun  insertTitle(title: Title): Resource<Long>

    fun getTitles(category: Int): Flow<List<Title>>
}