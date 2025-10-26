package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.repository.BookeeperRepository

class TasksViewmodelFactory(
    private val repository: BookeeperRepository
) : ViewModelProvider.Factory {

    // 2. Система вызывает этот метод, когда ей нужно создать ViewModel.
    //    Параметр modelClass - это класс ViewModel, которую нужно создать (например, GardenViewModel::class.java).
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // 3. Мы проверяем, соответствует ли запрошенный класс тому, что мы умеем создавать.
        if (modelClass.isAssignableFrom(TasksViewmodel::class.java)) {
            // 4. Если да - создаем экземпляр ViewModel, передавая в конструктор наш репозиторий.
            return TasksViewmodel(repository) as T
        }
        // 5. Если мы не знаем, как создавать такую ViewModel, выбрасываем исключение.
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}