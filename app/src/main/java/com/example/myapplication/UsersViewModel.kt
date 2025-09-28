package com.example.myapplication

// File: com/example/yourappname/UsersViewModel.kt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Класс состояния для нашего UI. Он описывает все возможные состояния экрана.
 * @param isLoading true, если идет загрузка, false - в противном случае.
 * @param users Список пользователей для отображения.
 */
data class UsersUiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList()
)

class UsersViewModel : ViewModel() {

    // Создаем экземпляр нашего репозитория. В больших проектах это делается через Dependency Injection.
    private val repository = UserRepository()

    // Приватный, изменяемый StateFlow для управления состоянием изнутри ViewModel
    private val _uiState = MutableStateFlow(UsersUiState(isLoading = true))

    // Публичный, read-only StateFlow, на который будет подписываться UI
    val uiState: StateFlow<UsersUiState> = _uiState.asStateFlow()

    // init блок вызывается при создании ViewModel
    init {
        loadUsers()
    }

    private fun loadUsers() {
        // Запускаем корутину в специальном viewModelScope.
        // Она будет жить, пока живет ViewModel.
        viewModelScope.launch {
            // Устанавливаем состояние "загрузки" перед запросом
            _uiState.update { it.copy(isLoading = true) }

            // Вызываем suspend-функцию репозитория для получения данных
            val userList = repository.getUsers()

            // Обновляем состояние новыми данными
            _uiState.update { currentState ->
                currentState.copy(
                    isLoading = false,
                    users = userList
                )
            }
        }
    }
}
