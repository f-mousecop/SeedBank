package com.example.seedbank.data

import com.example.seedbank.R
import com.example.seedbank.model.Plant

class Datasource() {
    fun loadPlants(): List<Plant> {
        return listOf<Plant>(
            Plant(R.string.arrowhead_plant, R.drawable.arrowhead_plant),
            Plant(R.string.cape_honeysuckle, R.drawable.cape_honeysuckle),
            Plant(R.string.zinnia, R.drawable.zinnia)
        )
    }
}