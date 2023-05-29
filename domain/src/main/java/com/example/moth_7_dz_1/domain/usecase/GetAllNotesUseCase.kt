package com.example.moth_7_dz_1.domain.usecase

import com.example.moth_7_dz_1.domain.repositories.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    fun getAllNotes() = noteRepository.getAllNotes()

}