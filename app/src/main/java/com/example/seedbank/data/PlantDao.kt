package com.example.seedbank.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(plant: Plant)

    @Update
    suspend fun update(plant: Plant)

    @Delete
    suspend fun delete(plant: Plant)

    @Query("SELECT * from plants WHERE id = :id")
    fun getPlant(id: Int): Flow<Plant>

    @Query("SELECT * from plants ORDER BY name ASC")
    fun getAllPlants(): Flow<List<Plant>>
}