package com.example.myapplication.viewmodel

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.database.entity.DrugEntity
import com.example.myapplication.data.database.entity.GardenEntity
import com.example.myapplication.data.database.entity.PlantEntity
import com.example.myapplication.data.repository.BookeeperRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow

class PlantsViewmodel(private val repository: BookeeperRepository) : ViewModel() {
    val plants = repository.allPlants
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    fun addPlant(
        name: String,
        period: Int,
        photo: String,
        taskId: Int?,
        drugId: Int?,
        gardenId: Int
    ) {
        viewModelScope.launch {
            try {
                val newPlant = PlantEntity(
                    name = name,
                    period = period,
                    photo = photo,
                    taskId = taskId,
                    drugId = drugId,
                    gardenId = gardenId
                )
                repository.insertPlant(newPlant)
            } catch (e: Exception) {
                Log.d("addPlant", e.toString())
            }
        }
    }
//    private val _listPlantsByGardenId :
//        Flow<List<PlantEntity>> = emptyList()
//    val listPlantsByGardenId = _listPlantsByGardenId.asStateFlow()
//    fun getPlantByGardenId(gardenId: Int): List<PlantEntity> {
//        viewModelScope.launch {
//            try {
//                _listPlantsByGardenId = repository.allPlantsByGardenId(gardenId)
//            } catch (e: Exception) {
//                Log.d("plantsById", e.toString())
//            }
//        }
//    }
}