package com.example.moth_7_dz_1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moth_7_dz_1.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}