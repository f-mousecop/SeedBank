package com.example.seedbank.data

import kotlinx.coroutines.flow.Flow

/** Repo that provides insert, update, delete, and retrieve of [Plant] from a given
 * data source
 * **/
interface PlantRepository {
    /**
     * Retrieve all plants from the given data source
     * */
    fun getAllPlantsStream(): Flow<List<Plant>>

    /**
     * Retrieve a plant from the given data source that matches with id
     * *
     * */
    fun getPlantStream(id: Int): Flow<Plant?>

    /**
     * Insert item in the data source
     * */
    suspend fun insertPlant(plant: Plant)

    /**
     * Delete item from source
     * */
    suspend fun deletePlant(plant: Plant)

    /**
     * Update plant in data source
     * */
    suspend fun updatePlant(plant: Plant)
}