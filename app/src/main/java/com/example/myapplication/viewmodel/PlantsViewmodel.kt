package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.database.entity.PlantEntity
import com.example.myapplication.data.repository.BookeeperRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Date

class PlantsViewmodel(private val repository: BookeeperRepository) : ViewModel() {
    val plants = repository.allPlants
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    fun deletePlant(id: Int) {
        viewModelScope.launch {
            try {
                repository.deletePlant(id)
            } catch (e: Exception) {
                Log.d("deletePlant", e.toString())
            }
        }
    }

    fun addPlant(
        plantName: String,
        taskName: String,
        wateringInterval: Int,
        creationDate: Date,
        plantPhoto: String,
        drugId: Int?,
        gardenId: Int?
    ) {
        viewModelScope.launch {
            try {
                val newPlant = PlantEntity(
                    plantName = plantName,
                    wateringInterval = wateringInterval,
                    creationDate = creationDate,
                    plantPhoto = plantPhoto,
                    taskName = taskName,
                    drugId = drugId,
                    gardenId = gardenId
                )
                repository.insertPlant(newPlant)
            } catch (e: Exception) {
                Log.d("addPlant", e.toString())
            }
        }
    }

}