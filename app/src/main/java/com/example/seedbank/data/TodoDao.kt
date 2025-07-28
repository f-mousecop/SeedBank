package com.example.seedbank.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: TodoNote)

    @Delete
    suspend fun delete(note: TodoNote)

    @Query("SELECT * FROM todo_notes ORDER BY timestamp DESC")
    fun getAllNotes(): Flow<List<TodoNote>>
}