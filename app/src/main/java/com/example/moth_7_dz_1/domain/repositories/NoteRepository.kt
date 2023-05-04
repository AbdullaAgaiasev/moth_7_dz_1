package com.example.moth_7_dz_1.domain.repositories

import com.example.moth_7_dz_1.domain.model.Note

interface NoteRepository {

     fun createNote(note: Note)

     fun getAllNotes(): List<Note>

     fun editNote(note: Note)

     fun removeNote(note: Note)


}