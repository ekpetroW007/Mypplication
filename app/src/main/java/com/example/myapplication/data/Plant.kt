package com.example.myapplication.data

data class Plant (
    val id: Int,
    val name: String,
    val targetID: Int,
    val period: Int,
    val plantPhoto: String,
    val drugID: Int,
    val gardenID: Int
)