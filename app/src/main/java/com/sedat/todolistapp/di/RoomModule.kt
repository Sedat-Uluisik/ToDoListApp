package com.sedat.todolistapp.di

import android.content.Context
import androidx.room.Room
import com.sedat.todolistapp.database.dao.ToDoDao
import com.sedat.todolistapp.database.db.ToDoDatabase
import com.sedat.todolistapp.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun toDoDatabase(@ApplicationContext context: Context): ToDoDatabase =
        Room.databaseBuilder(
            context,
            ToDoDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Provides
    @Singleton
    fun dao(db: ToDoDatabase): ToDoDao = db.toDoDao()
}