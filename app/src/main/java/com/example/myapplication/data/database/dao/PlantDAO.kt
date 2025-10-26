package com.example.myapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.database.entity.DrugEntity
import com.example.myapplication.data.database.entity.PlantEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDAO {
    @Insert
    suspend fun insertPlant(plant: PlantEntity)

    @Query("SELECT * FROM plant")
    fun getAllPlants(): Flow<List<PlantEntity>>

    @Query("SELECT * FROM plant WHERE garden_id = :gardenId")
    fun getPlantByGardenId(gardenId: Int): Flow<List<PlantEntity>>
}