package com.example.gitrobotdreamslessonssaveddata

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class Myapplication: Application() {
    private lateinit var mySharedPrefs:SharedPreferences

    override fun onCreate() {
        super.onCreate()
        instance = this
        mySharedPrefs = getSharedPreferences("MyNewSharedPrefs", Context.MODE_PRIVATE)
    }

    fun saveData(numberAsString:String){
        mySharedPrefs.edit().putString(prefsKey, numberAsString).apply()
    }

    fun getSavedData(): String {
        return mySharedPrefs.getString(prefsKey, "") ?: ""
    }
    companion object{
        private const val prefsKey = "MyNumberString"
        private lateinit var instance:Myapplication
        fun getApp() = instance
    }


}