package com.example.myapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.database.entity.DrugEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DrugDAO {
    // Вставить препарат. Если такой уже есть, он будет заменен
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrug(drug: DrugEntity)

    // Получить все препараты в виде Flow (поток данных, который автоматически обновляется)
    @Query("SELECT * FROM drug")
    fun getAllDrugs(): Flow<List<DrugEntity>>

    @Query("DELETE FROM drug WHERE id = :id ")
    suspend fun deleteDrug(id: Int)
}