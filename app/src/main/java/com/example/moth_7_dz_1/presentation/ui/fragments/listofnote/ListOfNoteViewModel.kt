package com.example.moth_7_dz_1.presentation.ui.fragments.listofnote

import com.example.moth_7_dz_1.domain.usecase.GetAllNotesUseCase
import com.example.moth_7_dz_1.domain.model.Note
import com.example.moth_7_dz_1.domain.usecase.RemoveNoteUseCase
import com.example.moth_7_dz_1.presentation.base.BaseViewModel
import com.example.moth_7_dz_1.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ListOfNoteViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val removeNoteUseCase: RemoveNoteUseCase
) : BaseViewModel() {

    private val _getAllNoteState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNoteState = _getAllNoteState.asStateFlow()

    private val _removeNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val removeNoteState = _removeNoteState.asStateFlow()

    fun getAllNotes() {
        getAllNotesUseCase.getAllNotes().collectData(_getAllNoteState)
    }

    fun removeNote(note:Note) {
        removeNoteUseCase.removeNote(note).collectData(_removeNoteState)
    }
}