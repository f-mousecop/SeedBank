package com.example.seedbank.data

import android.content.Context

/**
 * App container for dependenct injection
 * */
interface AppContainer {
    val plantRepository: PlantRepository
    val todoRepository: TodoRepository
}

/***
 * [AppContainer] implementation that provides instance of [OfflinePlantRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [PlantRepository]
     * */
    override val plantRepository: PlantRepository by lazy {
        OfflinePlantRepository(PlantDatabase.getDatabase(context).plantDao())
    }

    override val todoRepository: TodoRepository by lazy {
        TodoRepository(PlantDatabase.getDatabase(context).todoDao())
    }
}