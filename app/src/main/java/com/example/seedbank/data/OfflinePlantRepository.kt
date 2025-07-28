package com.example.seedbank.data

import kotlinx.coroutines.flow.Flow

class OfflinePlantRepository(private val plantDao: PlantDao) : PlantRepository {
    override fun getAllPlantsStream(): Flow<List<Plant>> = plantDao.getAllPlants()

    override fun getPlantStream(id: Int): Flow<Plant?> = plantDao.getPlant(id)

    override suspend fun insertPlant(plant: Plant) = plantDao.insert(plant)

    override suspend fun deletePlant(plant: Plant) = plantDao.delete(plant)

    override suspend fun updatePlant(plant: Plant) = plantDao.update(plant)

    override fun getPlantCount(): Flow<Int> = plantDao.getPlantCount()
}