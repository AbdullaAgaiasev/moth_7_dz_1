package com.example.moth_7_dz_1.data.repositories

import com.example.moth_7_dz_1.data.local.NoteDao
import com.example.moth_7_dz_1.domain.model.Note
import com.example.moth_7_dz_1.domain.repositories.NoteRepository

class NoteRepositoryImpl(
    private val noteDao: NoteDao
): NoteRepository {
    override fun createNote(note: Note) {
        noteDao.createNote(note)
    }

    override fun getAllNotes(): List<Note> {
        return noteDao.getAllNotes()
    }

    override fun editNote(note: Note) {

    }

    override fun removeNote(note: Note) {

    }
}