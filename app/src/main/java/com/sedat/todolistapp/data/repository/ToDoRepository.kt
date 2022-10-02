package com.sedat.todolistapp.data.repository

import com.sedat.todolistapp.model.Title
import com.sedat.todolistapp.utils.Resource

interface ToDoRepository {
    suspend fun  insertTitle(title: Title): Resource<Long>
}