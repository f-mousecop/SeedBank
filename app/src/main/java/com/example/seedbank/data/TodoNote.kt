package com.example.seedbank.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_notes")
data class TodoNote(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String,
    val timestamp: Long = System.currentTimeMillis(),
    val completed: Boolean = false
)
