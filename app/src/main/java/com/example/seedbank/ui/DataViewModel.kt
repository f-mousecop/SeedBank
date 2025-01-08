package com.example.seedbank.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    private val _plantList = mutableStateListOf<PlantData>()
    val plantList: List<PlantData> get() = _plantList

    private val _seedList = mutableStateListOf<SeedData>()
    val seedList: List<SeedData> get() = _seedList

    fun addPlant(text: String) {
        _plantList.add(PlantData(_plantList.size + 1, text = text))
    }

    fun addSeed(text: String) {
        _seedList.add(SeedData(_seedList.size + 1, text = text))
    }

    fun togglePlant(id: Int) {
        val index = _plantList.indexOfFirst { it.id == id }
        if(index != -1) {
            val updatePlant = _plantList[index].copy(isHealthy = !_plantList[index].isHealthy)
            _plantList[index] = updatePlant
        }
        /*_plantList.find { it.id == id }?.let {
            val index = _plantList.indexOf(it)
            _plantList[index] = it.copy(isHealthy = !it.isHealthy)
        }*/
    }

    fun deletePlant(id: Int) {
        _plantList.removeAll { it.id == id }
    }

    fun deleteSeed(id: Int) {
        _seedList.removeAll { it.id == id }
    }
}

/*
private fun updateDataState(updatedPlants: Int) {
    _uiState.update { currentState ->
        currentState.copy(
            currentPlants = currentState.currentPlants.inc(),
            currentSeeds = currentState.currentSeeds.inc()
        )
    }
}*/
