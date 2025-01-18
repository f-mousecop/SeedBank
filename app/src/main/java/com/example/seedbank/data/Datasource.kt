package com.example.seedbank.data

import com.example.seedbank.R
import com.example.seedbank.model.PlantType

class Datasource() {
    fun loadPlants(): List<PlantType> {
        return listOf<PlantType>(
            PlantType(R.string.arrowhead_plant, R.drawable.arrowhead_plant),
            PlantType(R.string.cape_honeysuckle, R.drawable.cape_honeysuckle),
            PlantType(R.string.zinnia, R.drawable.zinnia)
        )
    }
}