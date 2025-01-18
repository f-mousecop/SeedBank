package com.example.seedbank.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.seedbank.SeedBankApplication

/**
 * Provides factory to create instance of viemodel for entire seed bank app
 * */
object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for PlantEntryViewModel
        initializer {
            PlantEntryViewModel(seedBankApplication().container.plantRepository)
        }
    }
}

fun CreationExtras.seedBankApplication(): SeedBankApplication {
    return this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as? SeedBankApplication
        ?: throw IllegalStateException("Application is not an instance of SeedBankApplication")
}
