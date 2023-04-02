package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences

class SharedPreference private constructor(context: Context)
{
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
    private val prefsEditor: SharedPreferences.Editor = sharedPreferences.edit()

    companion object {

        @Volatile
        private var instance: SharedPreference? = null

        fun getInstance(context: Context): SharedPreference {
            return instance ?: synchronized(this) {
                instance ?: SharedPreference(context).also { instance = it }
            }
        }
    }

    fun saveData(key: String, value: String) {
        prefsEditor.putString(key, value).apply()
    }

    fun getData(key: String): String {
        return sharedPreferences.getString(key, "") ?: ""
    }
    fun saveInt(key: String, value: Int) {
        prefsEditor.putInt(key, value).apply()
    }

    fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    fun saveBoolean(key: String, value: Boolean) {
        prefsEditor.putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun clearData() {
        prefsEditor.clear().apply()
    }

    fun isSaveActivity(context: Context): Boolean {
        val sharedPreferences = context.getSharedPreferences("saveActivity", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("flag", false)
    }

}