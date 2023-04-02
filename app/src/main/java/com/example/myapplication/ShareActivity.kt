package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ShareActivity : AppCompatActivity() {
    lateinit var sharedPreference:SharedPreference
    lateinit var name:EditText
    lateinit var save:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        name = findViewById(R.id.names)
        sharedPreference=SharedPreference.getInstance(applicationContext)
        save = findViewById(R.id.saved)
        save.setOnClickListener {
            sharedPreference.saveData("name",name.text.toString())
            startActivity( Intent(applicationContext,Next::class.java))
        }
    }
}