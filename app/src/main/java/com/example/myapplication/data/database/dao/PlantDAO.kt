package com.example.myapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.myapplication.data.database.entity.PlantEntity

@Dao
interface PlantDAO {
    @Insert
    suspend fun insertPlantName(plant: PlantEntity)

    @Insert
    suspend fun insertPlantTask(plant: PlantEntity)

    @Insert
    suspend fun insertPlantGarden(plant: PlantEntity)

    @Insert
    suspend fun insertPlantPeriod(plant: PlantEntity)

    @Insert
    suspend fun insertPlantPhoto(plant: PlantEntity)
}