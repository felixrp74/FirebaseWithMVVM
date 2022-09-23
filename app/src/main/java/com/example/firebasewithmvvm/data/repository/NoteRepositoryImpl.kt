package com.example.firebasewithmvvm.data.repository

import com.example.firebasewithmvvm.data.model.Note
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class NoteRepositoryImpl(
    val database: FirebaseFirestore
):NoteRepository {
    override fun getNotes(): List<Note> {
        return arrayListOf(
            Note("2324","unida la costa", Date()),
            Note("2324","cosechando ", Date())
        )
    }
}