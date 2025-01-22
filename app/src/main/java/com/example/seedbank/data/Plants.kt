package com.example.seedbank.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val species: String,
    val type: String,
    val growthTime: String,
    val quantity: Int
)

/*@Entity(tableName = "seeds")
data class Seed(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val species: String,
    val type: String,
    val germinationTime: Double,
    val quantity: Int
)*/
