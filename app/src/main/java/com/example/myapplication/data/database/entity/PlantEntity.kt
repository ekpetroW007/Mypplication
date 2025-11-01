package com.example.myapplication.data.database.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "plant",
    foreignKeys = [
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
            onDelete = ForeignKey.SET_NULL
        )
    ]
)
data class PlantEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "name")
    val plantName: String,

    @ColumnInfo(name = "task")
    val taskName: String,

    @ColumnInfo(name = "period")
    val period: Int,

    @ColumnInfo(name = "firstDayOfPeriod")
    val firstDayOfPeriod: LocalDate = LocalDate.now(),

    @ColumnInfo(name = "photo_path")
    val plantPhoto: String,

    @ColumnInfo(name = "drug_id", index = true)
    val drugId: Int?,

    @ColumnInfo(name = "garden_id", index = true)
    val gardenId: Int?
)