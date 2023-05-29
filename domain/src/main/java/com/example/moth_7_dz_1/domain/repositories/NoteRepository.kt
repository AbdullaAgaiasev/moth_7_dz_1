package com.example.moth_7_dz_1.domain.repositories

import com.example.moth_7_dz_1.domain.model.Note
import com.example.moth_7_dz_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

     fun createNote(note: Note) : Flow<Resource<Unit>>

     fun getAllNotes(): Flow<Resource<List<Note>>>

     fun editNote(note: Note) : Flow<Resource<Unit>>

     fun removeNote(note: Note) : Flow<Resource<Unit>>


}