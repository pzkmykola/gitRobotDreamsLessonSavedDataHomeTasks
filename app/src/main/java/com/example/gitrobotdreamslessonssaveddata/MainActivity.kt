package com.example.gitrobotdreamslessonssaveddata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var myNumberAsString:String = ""
    private var myNumber:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textMyNumber: TextView = findViewById(R.id.myNumber)
        myNumberAsString = Myapplication.getApp().getSavedData()
        if(myNumberAsString == "") myNumber = 0
        else myNumber = myNumberAsString.toInt()
        textMyNumber.text = "My number is: $myNumber"
        val fabButtonPlus: FloatingActionButton = findViewById(R.id.fabPlus)
        val fabButtonMinus: FloatingActionButton = findViewById(R.id.fabMinus)

        fabButtonPlus.setOnClickListener {
            if(myNumberAsString == "") {
                myNumber = 0
            }
            else {
                myNumber = myNumberAsString.toInt()
            }
            myNumber++
            myNumberAsString = myNumber.toString()
            myNumberAsString.let { Myapplication.getApp().saveData(it) }
            textMyNumber.text = "My number is: $myNumber"
        }

        fabButtonMinus.setOnClickListener {
            if(myNumberAsString == "") {
                myNumber = 0
            }
            else {
                myNumber = myNumberAsString.toInt()
            }
            myNumber--
            myNumberAsString = myNumber.toString()
            myNumberAsString.let { Myapplication.getApp().saveData(it) }
            textMyNumber.text = "My number is: $myNumber"
        }
    }
    override fun onPause() {
        super.onPause()
        myNumberAsString.let { Myapplication.getApp().saveData(it) }
    }
}