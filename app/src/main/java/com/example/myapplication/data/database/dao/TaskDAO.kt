package com.example.myapplication.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.myapplication.data.database.entity.TaskEntity

@Dao
interface TaskDAO {

    @Insert
    suspend fun insertTask(task: TaskEntity)
}
