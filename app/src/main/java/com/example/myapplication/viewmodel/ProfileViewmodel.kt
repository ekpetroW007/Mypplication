package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel

class ProfileViewmodel : ViewModel() {
    fun addPlant() {
        // добавление растения
    }

    fun deletePlant() {
        // удаление растения
    }

    fun taskCompleted() {
        // юзер отмечает задачу сделанной, и она зачеркивается
    }

    fun showWeekOrMonth() {
        // юзер выбирает, показывать календарь на месяц или показывать только на неделю в верху экрана
    }

    fun noTasksScreen() {
        // юзер выбирает дату, на которую он никаких задач еще не планировал
    }

    fun screenWithTasks() {
        // экран, который показывается, когда юзер выбирает дату, на которую он уже запланировал что-то
    }
}