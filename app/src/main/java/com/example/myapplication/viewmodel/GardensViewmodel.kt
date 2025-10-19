package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repository.GardenRepository

class GardensViewmodel(repository: GardenRepository) : ViewModel() {
    fun gardenExport() {
        // экспорт сада
    }

    fun gardenAdd() {

        // создание нового сада
    }
}