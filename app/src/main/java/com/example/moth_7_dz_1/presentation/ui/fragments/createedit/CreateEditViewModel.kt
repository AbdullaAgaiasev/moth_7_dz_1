package com.example.moth_7_dz_1.presentation.ui.fragments.createedit

import com.example.moth_7_dz_1.domain.model.Note
import com.example.moth_7_dz_1.domain.usecase.CreateNoteUseCase
import com.example.moth_7_dz_1.domain.usecase.EditNoteUseCase
import com.example.moth_7_dz_1.presentation.base.BaseViewModel
import com.example.moth_7_dz_1.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateEditViewModel @Inject constructor(
    private val editNoteUseCase: com.example.moth_7_dz_1.domain.usecase.EditNoteUseCase,
    private val createNoteUseCase: com.example.moth_7_dz_1.domain.usecase.CreateNoteUseCase
) : BaseViewModel() {
    private val _editNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteState.asStateFlow()

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    fun editNote(note: com.example.moth_7_dz_1.domain.model.Note) {
        editNoteUseCase.editNote(note).collectData(_editNoteState)
    }
    fun createNote(note: com.example.moth_7_dz_1.domain.model.Note) {
        createNoteUseCase.createNote(note).collectData(_createNoteState)
    }
}