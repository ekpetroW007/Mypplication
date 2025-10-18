package com.example.myapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.database.dao.*
import com.example.myapplication.data.database.entity.*

@Database(
    entities = [
        DrugEntity::class,
        GardenEntity::class,
        PlantEntity::class,
        TaskEntity::class
    ],
    version = 1,
    exportSchema = false // Для простоты отключаем экспорт схемы
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun drugDao(): DrugDAO
    abstract fun gardenDao(): GardenDAO
    abstract fun plantDao(): PlantDAO
    abstract fun taskDao(): TaskDAO

    companion object {
        // @Volatile гарантирует, что значение INSTANCE всегда будет актуальным
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "bookeper_database" // Имя файла бд
                )
                    .fallbackToDestructiveMigration() // При обновлении версии бд, старые данные будут удалены
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}