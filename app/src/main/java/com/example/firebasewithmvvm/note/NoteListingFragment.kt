package com.example.firebasewithmvvm.note

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.firebasewithmvvm.databinding.FragmentNoteListingBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class NoteListingFragment : Fragment() {
    val TAG = "NoteListingFragment"
    private lateinit var binding: FragmentNoteListingBinding

    private val viewModel:NoteViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteListingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.getNotes()
        viewModel.note.observe(viewLifecycleOwner){
            it.forEach { note ->
                Log.d(TAG,note.toString())
            }
        }
    }
}