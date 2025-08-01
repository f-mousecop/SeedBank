package com.example.seedbank.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seedbank.data.TodoNote
import com.example.seedbank.data.TodoRepository
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {
    val allNotes = repository.getAllNotes()

    fun addNote(content: String) {
        viewModelScope.launch {
            repository.insertNote(content)
        }
    }

    fun removeNote(note: TodoNote) {
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }

    fun toggleNoteCompletion(note: TodoNote) {
        val updatedNote = note.copy(completed = !note.completed)
        viewModelScope.launch {
            repository.updateNote(updatedNote)
        }
    }
}