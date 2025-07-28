package com.example.seedbank.data

import kotlinx.coroutines.flow.Flow

class TodoRepository(private val todoDao: TodoDao) {
    fun getAllNotes(): Flow<List<TodoNote>> = todoDao.getAllNotes()

    suspend fun insertNote(content: String) {
        todoDao.insert(TodoNote(content = content))
    }

    suspend fun deleteNote(note: TodoNote) {
        todoDao.delete(note)
    }
}