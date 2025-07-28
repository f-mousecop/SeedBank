package com.example.seedbank.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.seedbank.data.PlantRepository

class DataViewModel(private val plantRepository: PlantRepository) : ViewModel() {
    private val _plantList = mutableStateListOf<PlantData>()
    val plantList: List<PlantData> get() = _plantList

    private val _seedList = mutableStateListOf<SeedData>()
    val seedList: List<SeedData> get() = _seedList

    /*fun addPlant(text: String) {
        _plantList.add(PlantData(_plantList.size + 1, text = text))
    }*/

    fun addSeed(text: String) {
        _seedList.add(SeedData(_seedList.size + 1, text = text))
    }

    /*fun togglePlant(id: Int) {
        val index = _plantList.indexOfFirst { it.id == id }
        if(index != -1) {
            val updatePlant = _plantList[index].copy(isHealthy = !_plantList[index].isHealthy)
            _plantList[index] = updatePlant
        }*/
        /*_plantList.find { it.id == id }?.let {
            val index = _plantList.indexOf(it)
            _plantList[index] = it.copy(isHealthy = !it.isHealthy)
        }*/
    }

    /*fun toggleSeed(id: Int) {
        val index = _seedList.indexOfFirst { it.id == id }
        if(index != -1) {
            val updateSeed = _seedList[index].copy(isGrowing = !_seedList[index].isGrowing)
            _seedList[index] = updateSeed
        }
    }*/

    /*fun deletePlant(id: Int) {
        _plantList.removeAll { it.id == id }
    }

    fun deleteSeed(id: Int) {
        _seedList.removeAll { it.id == id }
    }
}*/

/*
private fun updateDataState(updatedPlants: Int) {
    _uiState.update { currentState ->
        currentState.copy(
            currentPlants = currentState.currentPlants.inc(),
            currentSeeds = currentState.currentSeeds.inc()
        )
    }
}*/
