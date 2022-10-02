package com.sedat.todolistapp.di

import com.sedat.todolistapp.data.repository.ToDoRepository
import com.sedat.todolistapp.data.repository.ToDoRepositoryImpl
import com.sedat.todolistapp.database.dao.ToDoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(dao: ToDoDao): ToDoRepository{
        return ToDoRepositoryImpl(dao)
    }
}