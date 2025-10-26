package com.example.myapplication.data.repository

import com.example.myapplication.data.database.dao.DrugDAO
import com.example.myapplication.data.database.dao.GardenDAO
import com.example.myapplication.data.database.dao.PlantDAO
import com.example.myapplication.data.database.dao.TaskDAO
import com.example.myapplication.data.database.entity.DrugEntity
import com.example.myapplication.data.database.entity.GardenEntity
import com.example.myapplication.data.database.entity.PlantEntity
import com.example.myapplication.data.database.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

// В конструктор передаем DAO, которые нам нужны
class BookeeperRepository(
    private val drugDao: DrugDAO,
    private val plantDAO: PlantDAO,
    private val taskDAO: TaskDAO,
    private val gardenDAO: GardenDAO
) {
    // Пример функции для добавления нового препарата
    suspend fun insertDrug(drug: DrugEntity) {
        drugDao.insertDrug(drug)
    }

    suspend fun deleteDrug(drug: DrugEntity) {
        drugDao.deleteDrug(drug)
    }

    suspend fun insertTask(task: TaskEntity) {
        taskDAO.insertTask(task)
    }

    suspend fun insertGarden(garden: GardenEntity) {
        gardenDAO.insertGarden(garden)
    }

    suspend fun deleteGarden(garden: GardenEntity) {
        gardenDAO.deleteGarden(garden)
    }

    val allDrugs: Flow<List<DrugEntity>> = drugDao.getAllDrugs()
    val allGardens: Flow<List<GardenEntity>> = gardenDAO.getAllGardens()
    val allTasks: Flow<List<TaskEntity>> = taskDAO.getAllTasks()
    val allPlants: Flow<List<PlantEntity>> = plantDAO.getAllPlants()

    suspend fun insertPlant(plant: PlantEntity) {
        plantDAO.insertPlant(plant)
    }
}