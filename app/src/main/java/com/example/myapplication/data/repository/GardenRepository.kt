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
class GardenRepository(
    private val drugDao: DrugDAO,
    private val plantDAO: PlantDAO,
    private val taskDAO: TaskDAO,
    private val gardenDAO: GardenDAO
) {
    // Пример функции для получения всех препаратов
    val allDrugs: Flow<List<DrugEntity>> = drugDao.getAllDrugs()

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

    suspend fun deleteGarden(garden: GardenEntity) {
        gardenDAO.deleteGarden(garden)
    }

    val exportDrugs: Flow<List<GardenEntity>> = gardenDAO.exportGardens()

    suspend fun insertPlantName(plant: PlantEntity) {
        plantDAO.insertPlantName(plant)
    }

    suspend fun insertPlantTask(plant: PlantEntity) {
        plantDAO.insertPlantTask(plant)
    }

    suspend fun insertPlantGarden(plant: PlantEntity) {
        plantDAO.insertPlantGarden(plant)
    }

    suspend fun insertPlantPeriod(plant: PlantEntity) {
        plantDAO.insertPlantPeriod(plant)
    }

    suspend fun insertPlantPhoto(plant: PlantEntity) {
        plantDAO.insertPlantPhoto(plant)
    }
}