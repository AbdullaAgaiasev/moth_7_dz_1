package com.example.moth_7_dz_1.domain.model

import java.io.Serializable

class Note(
    val id: Int = DEFAULT_ID,
    var title: String,
    var desc: String
): Serializable {
    companion object {
        const val DEFAULT_ID = 0
    }
}