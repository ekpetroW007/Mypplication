package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.database.entity.PlantEntity
import com.example.myapplication.data.repository.BookeeperRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch

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
        period: Int,
        firstDayOfPeriod: Long,
        plantPhoto: String,
        drugId: Int?,
        gardenId: Int?
    ) {
        viewModelScope.launch {
            try {
                val newPlant = PlantEntity(
                    plantName = plantName,
                    period = period,
                    firstDayOfPeriod = firstDayOfPeriod,
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

    private val _plantsByGardenId = MutableStateFlow<List<PlantEntity>>(emptyList())
    val plantsByGardenId: StateFlow<List<PlantEntity>> = _plantsByGardenId.asStateFlow()

    fun loadPlantsByGardenId(gardenId: Int) {
        viewModelScope.launch {
            repository.allPlantsByGardenId(gardenId)
                .catch { exception ->
                    Log.d(
                        "PlantsViewModel",
                        "Exception while fetching plants by garden ID",
                        exception
                    )
                    _plantsByGardenId.value =
                        emptyList()
                }
                .collect { plants ->
                    _plantsByGardenId.value = plants
                }
        }
    }

}