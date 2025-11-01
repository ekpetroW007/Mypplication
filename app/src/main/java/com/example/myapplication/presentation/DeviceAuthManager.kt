//package com.example.myapplication.presentation
//
//import android.content.Context
//import androidx.security.crypto.EncryptedSharedPreferences
//import androidx.security.crypto.MasterKeys
//import java.util.*
//
//class DeviceAuthManager(private val context: Context) {
//
//    private val sharedPreferences = EncryptedSharedPreferences.create(
//        "secure_prefs",
//        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
//        context,
//        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
//        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
//    )
//
//    companion object {
//        private const val KEY_DEVICE_ID = "device_id"
//        private const val KEY_IS_REGISTERED = "is_registered"
//    }
//
//    // Генерация уникального идентификатора устройства
//    private fun getDeviceId(): String = android.provider.Settings.Secure.getString(
//        context.contentResolver,
//        android.provider.Settings.Secure.ANDROID_ID
//    ) ?: UUID.randomUUID().toString()
//
//    fun registerDevice() {
//        val editor = sharedPreferences.edit()
//        editor.putString(KEY_DEVICE_ID, getDeviceId())
//        editor.putBoolean(KEY_IS_REGISTERED, true)
//        editor.apply()
//    }
//
//    fun isDeviceRegistered(): Boolean {
//        val savedId = sharedPreferences.getString(KEY_DEVICE_ID, null)
//        val isRegistered = sharedPreferences.getBoolean(KEY_IS_REGISTERED, false)
//        return isRegistered && savedId == getDeviceId()
//    }
//
//    fun clearRegistration() {
//        sharedPreferences.edit().clear().apply()
//    }
//}