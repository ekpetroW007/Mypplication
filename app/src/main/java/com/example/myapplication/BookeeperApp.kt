package com.example.myapplication

import android.app.Application
import kotlin.getValue
import com.example.myapplication.data.database.AppDatabase
import com.example.myapplication.data.repository.GardenRepository

class BookeeperApp: Application() {
    private val database by lazy { AppDatabase.getDatabase(this) }

    // Создаем экземпляр репозитория, передавая ему все необходимые DAO из нашей базы данных
    val repository by lazy {
        GardenRepository(
            drugDao = database.drugDao(),
        // ... добавь сюда остальные DAO по мере появления
        )
    }
}