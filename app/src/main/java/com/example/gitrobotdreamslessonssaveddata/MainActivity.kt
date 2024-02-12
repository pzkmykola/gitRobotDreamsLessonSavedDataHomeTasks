package com.example.gitrobotdreamslessonssaveddata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var myNumber:Int = 0
    private var textHolder:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textMyNumber: TextView = findViewById(R.id.myNumber)
        val fabButtonPlus: FloatingActionButton = findViewById(R.id.fabPlus)
        val fabButtonMinus: FloatingActionButton = findViewById(R.id.fabMinus)

        myNumber = Myapplication.getApp().getSavedNumber()
        textHolder = getString(R.string.txt_my_number)
        textMyNumber.text = buildString {
            append(textHolder)
            append(myNumber)
        }

        fabButtonPlus.setOnClickListener {
            myNumber++
            Myapplication.getApp().saveNumber(myNumber)
            textMyNumber.text = buildString {
                append(textHolder)
                append(myNumber)
            }
        }

        fabButtonMinus.setOnClickListener {
            myNumber--
            Myapplication.getApp().saveNumber(myNumber)
            textMyNumber.text = buildString {
                append(textHolder)
                append(myNumber)
            }
        }
    }
    override fun onPause() {
        super.onPause()
        Myapplication.getApp().saveNumber(myNumber)
    }
}