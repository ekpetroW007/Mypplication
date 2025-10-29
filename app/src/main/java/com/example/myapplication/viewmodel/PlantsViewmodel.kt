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
        name: String,
        task: String,
        period: Int,
        photo: String,
        drugId: Int?,
        gardenId: Int
    ) {
        viewModelScope.launch {
            try {
                val newPlant = PlantEntity(
                    name = name,
                    period = period,
                    photo = photo,
                    task = task,
                    drugId = drugId,
                    gardenId = gardenId
                )
                repository.insertPlant(newPlant)
            } catch (e: Exception) {
                Log.d("addPlant", e.toString())
            }
        }
    }

    // StateFlow для хранения списка растений для конкретного сада.
    // Используем MutableStateFlow, чтобы иметь возможность обновлять его значение.
    private val _plantsByGardenId = MutableStateFlow<List<PlantEntity>>(emptyList())
    val plantsByGardenId: StateFlow<List<PlantEntity>> = _plantsByGardenId.asStateFlow()

    // Функция для загрузки растений по ID сада.
    fun loadPlantsByGardenId(gardenId: Int) {
        viewModelScope.launch {
            repository.allPlantsByGardenId(gardenId)
                .catch { exception ->
                    // Обработка возможных ошибок при получении данных из БД
                    Log.d(
                        "PlantsViewModel",
                        "Exception while fetching plants by garden ID",
                        exception
                    )
                    _plantsByGardenId.value =
                        emptyList() // В случае ошибки показываем пустой список
                }
                .collect { plants ->
                    // Как только Flow эмитит новые данные, мы обновляем наш StateFlow.
                    _plantsByGardenId.value = plants
                }
        }
    }

}