package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Garden

class GardensViewmodel : ViewModel() {
    fun gardenExport() {
        // экспорт сада
    }

    fun gardenAdd() {
        Garden(
            1, "Мой сад", 1
        )
        // создание нового сада
    }
}