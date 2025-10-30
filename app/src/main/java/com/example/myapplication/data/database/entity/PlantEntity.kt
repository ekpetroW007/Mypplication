package com.example.myapplication.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "plant",
    foreignKeys = [
        ForeignKey(
            entity = TaskEntity::class,
            parentColumns = ["id"],
            childColumns = ["task_id"],
            onDelete = ForeignKey.SET_NULL // При удалении задачи, у растения это поле станет null
        ),
        ForeignKey(
            entity = DrugEntity::class,
            parentColumns = ["id"],
            childColumns = ["drug_id"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = GardenEntity::class,
            parentColumns = ["id"],
            childColumns = ["garden_id"],
            onDelete = ForeignKey.CASCADE // При удалении сада, все его растения тоже удалятся
        )
    ]
)
data class PlantEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "task")
    val task: String,

    @ColumnInfo(name = "period")
    val period: Int,

    @ColumnInfo(name = "photo_path")
    val photo: String,

    @ColumnInfo(name = "drug_id", index = true)
    val drugId: Int,

    @ColumnInfo(name = "garden_id", index = true)
    val gardenId: Int
)