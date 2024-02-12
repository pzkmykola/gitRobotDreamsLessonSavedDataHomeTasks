package com.example.gitrobotdreamslessonssaveddata

interface Model {
    fun setItem(number:Int)
    fun getNumber(): Int
}
object ModelImpl : Model {
    private var itemNumber : Int = Myapplication.getApp().getSavedNumber()

    override fun setItem(number:Int){
        itemNumber = number
    }
    override fun getNumber(): Int {
        return itemNumber
    }

}
