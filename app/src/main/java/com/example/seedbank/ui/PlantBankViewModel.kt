package com.example.seedbank.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seedbank.data.Plant
import com.example.seedbank.data.PlantRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PlantBankViewModel(private val plantsRepository: PlantRepository) : ViewModel() {

    val plantBankUiState: StateFlow<PlantBankUiState> =
        plantsRepository.getAllPlantsStream().map { PlantBankUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = PlantBankUiState()
            )
    fun deletePlant(plant: Plant) {
        viewModelScope.launch {
            plantsRepository.deletePlant(plant)
        }
    }
    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class PlantBankUiState(val plantList: List<Plant> = listOf())