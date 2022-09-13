package com.sedat.todolistapp.di

import android.content.Context
import com.sedat.todolistapp.constants.CustomAlertDialog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AlertDialogModule {
    @Provides
    @Singleton
    fun injectCustomAlertDialog() = CustomAlertDialog()
}