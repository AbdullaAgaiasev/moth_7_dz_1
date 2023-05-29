package com.example.moth_7_dz_1.data.repositories

import com.example.moth_7_dz_1.data.base.BaseRepository
import com.example.moth_7_dz_1.data.local.NoteDao
import com.example.moth_7_dz_1.data.mappers.toEntity
import com.example.moth_7_dz_1.data.mappers.toNote
import com.example.moth_7_dz_1.data.model.NoteEntity
import com.example.moth_7_dz_1.domain.model.Note
import com.example.moth_7_dz_1.domain.repositories.NoteRepository
import com.example.moth_7_dz_1.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
): BaseRepository(), NoteRepository {

    override fun createNote(note: Note) = doRequest {
        noteDao.createNote(note.toEntity())
    }

    override fun getAllNotes() = doRequest {
        noteDao.getAllNotes().map { it.toNote() }
    }

    override fun editNote(note: Note) = doRequest{
        noteDao.editNote(note.toEntity())
    }

    override fun removeNote(note: Note) =doRequest {
        noteDao.removeNote(note.toEntity())
    }
//    = flow {
//        emit(Resource.Loading())
//        try {
//            val notes = noteDao.getAllNotes()
//            val mappedNotes = notes.map { noteEntity ->
//                Note(
//                    id = noteEntity.id,
//                    title = noteEntity.title,
//                    desc = noteEntity.desc
//                )
//            }
//            emit(Resource.Success(mappedNotes))
//        } catch (e: Exception) {
//            emit(Resource.Error(e.localizedMessage?: "unknown error"))
//        }
    }