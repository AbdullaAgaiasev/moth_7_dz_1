package com.example.moth_7_dz_1.presentation.ui.fragments.createedit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moth_7_dz_1.domain.model.Note
import com.example.moth_7_dz_1.presentation.base.BaseFragment
import com.example.moth_7_dz_1.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import om.example.moth_7_dz_1.databinding.FragmentCreateEditBinding

@AndroidEntryPoint
abstract class CreateEditFragment : BaseFragment() {

    private lateinit var binding: FragmentCreateEditBinding
    private val viewModel by viewModels<CreateEditViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    override fun initClickers() {
        binding.createEditBtn.setOnClickListener {
            if (arguments?.getInt("id") != null) {
                var note = arguments?.getSerializable("note") as com.example.moth_7_dz_1.domain.model.Note
                note.title = binding.titleEt.text.toString()
                note.desc = binding.descEt.text.toString()
                editNote(note = note)
                findNavController().navigateUp()
            } else {
                createNote(
                    com.example.moth_7_dz_1.domain.model.Note(
                        title = binding.titleEt.text.toString(),
                        desc = binding.descEt.text.toString()
                    )
                )
            }
        }
    }


    private fun createNote(note: com.example.moth_7_dz_1.domain.model.Note) {
        viewModel.createNote(note)
        viewModel.createNoteState.collectState(state = { state ->
            binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = {

        })
    }

    private fun editNote(note: com.example.moth_7_dz_1.domain.model.Note) {
        viewModel.editNote(note)
        viewModel.editNoteState.collectState(state = { state ->
            // binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = { data ->
            //adapter.addList(data)
        })
    }

}