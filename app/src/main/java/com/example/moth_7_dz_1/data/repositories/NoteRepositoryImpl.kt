package com.example.moth_7_dz_1.data.repositories

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
): NoteRepository {
    override fun createNote(note: Note): Flow<Resource<Unit>> {
        return  flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.createNote(note.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(
                    Resource.Error(e.localizedMessage?: "unknown error")
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getAllNotes(): Flow<Resource<List<Note>>> {
    return  flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.getAllNotes().map { it.toNote() }
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(
                Resource.Error(e.localizedMessage?: "unknown error")
            )
        }
    }.flowOn(Dispatchers.IO)
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

    override fun editNote(note: Note): Flow<Resource<Unit>> {
        return  flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.editNote(note.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(
                    Resource.Error(e.localizedMessage?: "unknown error")
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun removeNote(note: Note): Flow<Resource<Unit>> {
        return  flow {
            emit(Resource.Loading())
            try {
                val data = noteDao.removeNote(note.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(
                    Resource.Error(e.localizedMessage?: "unknown error")
                )
            }
        }.flowOn(Dispatchers.IO)
    }

}