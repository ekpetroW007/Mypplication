package com.example.myapplication.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class TextInputViewModel : ViewModel() {
    private val _message = mutableStateOf("")
    val message: State<String> = _message
    fun updateText(newText: String) {
        _message.value = newText
    }
    fun clearText() {
        _message.value = ""
    }
//    private val _count = mutableIntStateOf(0)
//    val count: State<Int> = _count
//    fun increment() {
//        _count.value++
//    }
}