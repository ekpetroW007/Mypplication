package com.example.myapplication



// File: com/example/yourappname/UserRepository.kt
// (Замени com.example.yourappname на имя своего пакета)

import kotlinx.coroutines.delay

// Модель данных для одного пользователя
data class User(val id: Int, val name: String)

/**
 * Это наш эмулятор базы данных.
 * В реальном приложении здесь был бы код для работы с Room, Retrofit или другой библиотекой.
 */
class UserRepository {

    // Приватный список, имитирующий таблицу в базе данных
    private val users = listOf(
        User(1, "Алиса"),
        User(2, "Борис"),
        User(3, "Виктор"),
        User(4, "Галина"),
        User(5, "Дмитрий")
    )

    /**
     * Функция, имитирующая получение данных. Она suspend, так как операция "долгая".
     */
    suspend fun getUsers(): List<User> {
        println("Запрос пользователей из 'базы данных'...")
        // Имитируем задержку сети или чтения с диска
        delay(2000L)
        println("Пользователи получены!")
        return users
    }
}

