package com.example.moth_7_dz_1.di

import android.content.Context
import androidx.room.Room
import com.example.moth_7_dz_1.data.local.NoteDao
import com.example.moth_7_dz_1.data.local.NoteDatabase
import com.example.moth_7_dz_1.data.repositories.NoteRepositoryImpl
import com.example.moth_7_dz_1.domain.repositories.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        "note_db"
    )

    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.noteDao()

    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }
}