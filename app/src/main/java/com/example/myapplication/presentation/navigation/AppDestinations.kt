package com.example.myapplication.presentation.navigation


/**
 * Объект для хранения всех маршрутов навигации в приложении.
 */
object AppDestinations {
    // Маршрут для главного экрана
    const val MAINSCREEN_ROUTE = "mainScreen"

    const val GARDEN_ROUTE = "garden"

    // Маршрут для экрана с детальной информацией о препарате.
    // Он будет принимать ID препарата в качестве аргумента.
    const val DRUG_DETAIL_ROUTE = "drug_detail"

    // Имя аргумента, который мы будем передавать.
    const val DRUG_ID_ARG = "drugId"

    const val DRUG_ADD_ROUTE = "drugsAddScreen"

    const val GARDEN_ADD = "gardenAddScreen"
}
