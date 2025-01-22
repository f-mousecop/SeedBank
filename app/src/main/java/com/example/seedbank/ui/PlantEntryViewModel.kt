package com.example.seedbank.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.seedbank.data.Plant
import com.example.seedbank.data.PlantRepository

/**
 * View model to validate and insert items in the Room DB
 * */
class PlantEntryViewModel(private val plantRepository: PlantRepository) : ViewModel() {

    /**
     * Holds current plant ui state
     * */
    var plantUiState by mutableStateOf(PlantUiState())
        private set

    /**
     * Updates itemUiState with the value provided in the argument. This method also triggers
     * a valdiation for input values
     * */
    fun updateUiState(plantDetails: PlantData) {
        plantUiState =
            PlantUiState(plantDetails = plantDetails, isEntryValid = validateInput(plantDetails))
    }

    private fun validateInput(uiState: PlantData = plantUiState.plantDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && species.isNotBlank() && type.isNotBlank()
                    && growthTime.isNotBlank() && quantity.isNotBlank()
        }
    }

    suspend fun saveItem() {
        if(validateInput()) {
            plantRepository.insertPlant(plantUiState.plantDetails.toPlant())
        }
    }
}

data class PlantUiState(
    val plantDetails: PlantData = PlantData(),
    val isEntryValid: Boolean = false
)

data class PlantData(
    val id: Int = 0,
    val name: String = "",
    val species: String = "",
    val type: String = "",
    val growthTime: String = "",
    val quantity: String = ""
)

fun PlantData.toPlant(): Plant = Plant(
    id = id,
    name = name,
    species = species,
    type = type,
    growthTime = growthTime,
    quantity = quantity.toIntOrNull() ?: 0
)

fun Plant.toPlantUiState(isEntryValid: Boolean = false): PlantUiState = PlantUiState(
    plantDetails = this.toPlantData(),
    isEntryValid = isEntryValid
)

fun Plant.toPlantData(): PlantData = PlantData(
    id = id,
    name = name,
    species = species,
    type = type,
    growthTime = growthTime,
    quantity = quantity.toString()
)