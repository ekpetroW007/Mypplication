package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.data.Drug
import com.example.myapplication.data.repository.GardenRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn

class DrugsViewmodel(
    private val repository: GardenRepository
) : ViewModel() {
    val drugs = repository.allDrugs
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )


    fun addDrug() {
        Drug(1, "Цинк", "Удобрить", 100)
        // юзер добавляет препарат
    }

    fun searchDrug() {
        // юзер вводит препарат
    }
}