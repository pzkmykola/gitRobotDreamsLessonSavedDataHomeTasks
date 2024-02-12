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
        val number = model.getNumber()
        model.setItem(number+1)
        itemsLiveData.value = number
    }
    fun setDecreasedNumber(){
        val number = model.getNumber()
        model.setItem(number-1)
        itemsLiveData.value = number - 1
    }
    fun saveNumber(): Int {
        return model.getNumber()
    }
}