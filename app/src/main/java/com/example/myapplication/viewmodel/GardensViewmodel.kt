package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repository.BookeeperRepository

class GardensViewmodel(repository: BookeeperRepository) : ViewModel() {
    fun gardenExport() {
        // экспорт сада
    }

    fun gardenAdd() {

        // создание нового сада
    }
}