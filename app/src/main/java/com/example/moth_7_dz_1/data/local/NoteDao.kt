package com.example.moth_7_dz_1.data.local

import androidx.room.*
import com.example.moth_7_dz_1.data.model.NoteEntity

@Dao
interface NoteDao {

    @Insert
    suspend fun createNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes ")
    suspend fun getAllNotes(): List<NoteEntity>

    @Update
    suspend fun editNote(noteEntity: NoteEntity)

    @Delete
    suspend fun removeNote(noteEntity: NoteEntity)

}