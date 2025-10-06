package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Drug

class DrugsViewmodel: ViewModel() {
    fun addDrug() {
        Drug(1, "Цинк", "Удобрить", 100)
        // юзер добавляет препарата
    }
    fun searchDrug() {
        // юзер вводит препарат
    }
}