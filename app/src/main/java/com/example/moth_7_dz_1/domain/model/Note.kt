package com.example.moth_7_dz_1.domain.model

class Note(
    val id: Int = DEFAULT_ID,
    val title: String,
    val desc: String
) {
    companion object {
        const val DEFAULT_ID = 0
    }
}