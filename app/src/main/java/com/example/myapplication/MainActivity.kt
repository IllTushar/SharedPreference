package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var password:EditText
    lateinit var checkBox: CheckBox
    lateinit var sharedPreferences: SharedPreferences
     var Name:String?=null
      var Message :String?=null
    var  isCheckBox:Boolean?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      name = findViewById(R.id.name)
        password = findViewById(R.id.password)
        checkBox = findViewById(R.id.checkbox)

    }

    override fun onPause() {
        super.onPause()
        saveData()
    }
    fun saveData():Unit{
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE)
        Name = name.text.toString()
        Message = password.text.toString()
        isCheckBox = checkBox.isChecked
        val editor = sharedPreferences.edit()
        editor.putString("name",Name)
        editor.putString("password",Message)
        editor.putBoolean("Key Remember",isCheckBox!!)
          editor.apply()
    }

    override fun onResume() {
        super.onResume()
        retrieveData()
    }
    fun retrieveData():Unit{
        sharedPreferences = this.getSharedPreferences("saveData",Context.MODE_PRIVATE)
        Name = sharedPreferences.getString("name",null)
        Message = sharedPreferences.getString("password",null)
        isCheckBox = sharedPreferences.getBoolean("Key Remember",false)
        name.setText(Name)
        password.setText(Message)
        checkBox.isChecked=isCheckBox!!
    }
}