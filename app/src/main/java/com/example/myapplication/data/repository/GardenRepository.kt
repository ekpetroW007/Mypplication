package com.example.myapplication.data.repository

import com.example.myapplication.data.database.dao.DrugDAO
import com.example.myapplication.data.database.dao.DrugDao
import com.example.myapplication.data.database.dao.GardenDAO
import com.example.myapplication.data.database.dao.PlantDAO
import com.example.myapplication.data.database.dao.TaskDAO
import com.example.myapplication.data.database.entity.DrugEntity
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
    // TODO (добавить остальные методы к другим DAO)
}