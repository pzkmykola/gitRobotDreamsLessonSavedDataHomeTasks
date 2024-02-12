package com.example.gitrobotdreamslessonssaveddata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabButtonPlus: FloatingActionButton = findViewById(R.id.fabPlus)
        val fabButtonMinus: FloatingActionButton = findViewById(R.id.fabMinus)
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.itemsLiveData.observe(this){
            val textMyNumber: TextView = findViewById(R.id.myNumber)
            textMyNumber.text = viewModel.saveNumber().toString()
        }

        fabButtonPlus.setOnClickListener {
            viewModel.setIncreasedNumber()
        }

        fabButtonMinus.setOnClickListener {
            viewModel.setDecreasedNumber()
        }
    }
    override fun onPause() {
        super.onPause()
        Myapplication.getApp().saveNumber(viewModel.saveNumber())
    }
}