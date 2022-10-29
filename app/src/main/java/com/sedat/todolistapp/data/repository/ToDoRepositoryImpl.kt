package com.sedat.todolistapp.data.repository

import com.sedat.todolistapp.database.dao.ToDoDao
import com.sedat.todolistapp.model.Title
import com.sedat.todolistapp.utils.Resource
import com.sedat.todolistapp.utils.getResourceByDatabaseRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(
    private val dao: ToDoDao
): ToDoRepository {
    override suspend fun insertTitle(title: Title): Resource<Long> {
        return getResourceByDatabaseRequest {
            dao.insertTitle(title)
        }
    }

    override fun getTitles(category: Int): Flow<List<Title>> {
        return dao.getTitles(category)
    }

}