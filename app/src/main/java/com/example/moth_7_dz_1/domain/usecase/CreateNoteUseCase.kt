package com.example.moth_7_dz_1.domain.usecase

import com.example.moth_7_dz_1.domain.model.Note
import com.example.moth_7_dz_1.domain.repositories.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {
    fun createNote(note: Note) = noteRepository.createNote(note)

}