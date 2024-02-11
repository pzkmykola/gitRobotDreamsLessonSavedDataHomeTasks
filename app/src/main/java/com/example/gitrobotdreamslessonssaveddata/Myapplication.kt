package com.example.gitrobotdreamslessonssaveddata

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class Myapplication: Application() {
    private lateinit var mySharedPrefs:SharedPreferences

    override fun onCreate() {
        super.onCreate()
        instance = this
        mySharedPrefs = getSharedPreferences("MySharedPrefs", Context.MODE_PRIVATE)
    }

    fun saveData(numberAsString:String){
        mySharedPrefs.edit().putString("MyNumberToString", numberAsString).apply()
    }

    fun getSavedData(): String {
        return mySharedPrefs.getString("MyNumberToString", "") ?: ""
    }
    companion object{
        private lateinit var instance:Myapplication
        fun getApp() = instance
    }
}