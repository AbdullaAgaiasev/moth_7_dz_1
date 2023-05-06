package com.example.moth_7_dz_1.data.mappers

import com.example.moth_7_dz_1.data.model.NoteEntity
import com.example.moth_7_dz_1.domain.model.Note

fun Note.toEntity() = NoteEntity(id, title, desc)

fun NoteEntity.toNote() = Note(id, title, desc)