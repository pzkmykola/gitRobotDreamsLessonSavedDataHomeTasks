package com.example.gitrobotdreamslessonssaveddata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val model = ModelImpl
    val itemsLiveData = MutableLiveData(model.getNumber())
    fun addItem(){
        val number = model.getNumber()
        model.setItem(number)
        itemsLiveData.value = number
    }
    fun setIncreasedNumber(){
        var number = model.getNumber()
        number++
        model.setItem(number)
        itemsLiveData.value = number
        Myapplication.getApp().saveNumber(number)
    }
    fun setDecreasedNumber(){
        var number = model.getNumber()
        number --
        model.setItem(number)
        itemsLiveData.value = number
        Myapplication.getApp().saveNumber(number)
    }
    fun saveNumber(): Int {
        val number = model.getNumber()
        Myapplication.getApp().saveNumber(number)
        return number
    }
}