package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Next : AppCompatActivity() {
    lateinit var textView:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)
        textView = findViewById(R.id.text)
        val sharedPreference = SharedPreference.getInstance(applicationContext).getData("name")
        textView.text = sharedPreference
    }
}