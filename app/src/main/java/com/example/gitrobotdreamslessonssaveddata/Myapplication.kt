package com.example.gitrobotdreamslessonssaveddata

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class Myapplication: Application() {
    private lateinit var mySharedPrefs:SharedPreferences
    private var numberAsString:String = ""
    override fun onCreate() {
        super.onCreate()
        instance = this
        mySharedPrefs = getSharedPreferences(getString(R.string.name_of_shared_prefs), Context.MODE_PRIVATE)
    }

    fun saveNumber(number:Int){
        numberAsString = number.toString()
        mySharedPrefs.edit().putString(prefsKey, numberAsString).apply()
    }

    fun getSavedNumber(): Int{
        var number = 0
        numberAsString = mySharedPrefs.getString(prefsKey, "") ?: ""
        if(numberAsString != "") {
            number = numberAsString.toInt()
        }
        return number
    }

    companion object{
        private const val prefsKey = "MyNumberString"
        private lateinit var instance:Myapplication
        fun getApp() = instance
    }


}