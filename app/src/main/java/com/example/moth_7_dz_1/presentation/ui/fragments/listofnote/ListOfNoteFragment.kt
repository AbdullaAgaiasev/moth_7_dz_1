package com.example.moth_7_dz_1.presentation.ui.fragments.listofnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.moth_7_dz_1.domain.model.Note
import com.example.moth_7_dz_1.presentation.base.BaseFragment
import com.example.moth_7_dz_1.presentation.ui.fragments.listofnote.adapter.ListOfNoteAdapter
import com.example.moth_7_dz_1.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import om.example.moth_7_dz_1.R
import om.example.moth_7_dz_1.databinding.FragmentListOfNoteBinding

@AndroidEntryPoint
class ListOfNoteFragment : BaseFragment() {
    private lateinit var binding: FragmentListOfNoteBinding
    private val viewModel by viewModels<ListOfNoteViewModel>()
    private lateinit var adapter: ListOfNoteAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListOfNoteBinding.inflate(inflater, container, false)
        return binding.root
        adapter = ListOfNoteAdapter(this::removeNote, this::editClick)
        binding.noteRv.adapter = adapter
    }



    override fun initClickers() {
        binding.addFab.setOnClickListener {
            findNavController().navigate(R.id.createEditFragment)
        }
    }

    fun editClick(note: com.example.moth_7_dz_1.domain.model.Note, id: Int){
        findNavController().navigate(R.id.createEditFragment, bundleOf(
            "note" to note,
            "id" to id
        ))
    }

    override fun loadView() {
        viewModel.getAllNotes()
        viewModel.getAllNoteState.collectState(state = {state->
            binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = { data ->
            adapter.addNotes(data)
        })
    }

    private fun removeNote(note: com.example.moth_7_dz_1.domain.model.Note, id: Int) {
        viewModel.removeNote(note)
        viewModel.removeNoteState.collectState(state = {state->
            binding.progressBar.isVisible = state is UIState.Loading
        }, onSuccess = { data ->
            loadView()
        })
    }
}