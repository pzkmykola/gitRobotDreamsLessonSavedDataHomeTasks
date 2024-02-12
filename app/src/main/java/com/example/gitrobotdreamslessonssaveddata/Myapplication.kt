package com.example.gitrobotdreamslessonssaveddata

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class Myapplication: Application() {
    private lateinit var mySharedPrefs:SharedPreferences
    override fun onCreate() {
        super.onCreate()
        instance = this
        mySharedPrefs = getSharedPreferences(getString(R.string.name_of_new_shared_prefs), Context.MODE_PRIVATE)
    }

    fun saveNumber(number:Int){
        mySharedPrefs.edit().putInt(prefsKey, number).apply()
    }

    fun getSavedNumber(): Int {
        return mySharedPrefs.getInt(prefsKey, 0) ?: 0
    }

    companion object{
        private const val prefsKey = "MyNumberString"
        private lateinit var instance:Myapplication
        fun getApp() = instance
    }


}