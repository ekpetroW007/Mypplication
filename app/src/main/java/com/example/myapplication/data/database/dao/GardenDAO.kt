package com.example.myapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.data.database.entity.DrugEntity
import com.example.myapplication.data.database.entity.GardenEntity
import com.example.myapplication.data.database.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GardenDAO {
    @Delete
    suspend fun deleteGarden(garden: GardenEntity)

    @Query("SELECT * FROM garden")
    fun getAllGardens(): Flow<List<GardenEntity>>
}