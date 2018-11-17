package com.apolosan.kotlinAndroidExamples.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.apolosan.kotlinAndroidExamples.R
import com.apolosan.kotlinAndroidExamples.app.preferences
import com.apolosan.kotlinAndroidExamples.extensions.toast
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        preferences.name = ""
        buttonSave.setOnClickListener{setValuesSharedPreferences(); cleanEditText(); getValuesSharedPreferences()} // ejecuta los dos metodos cuando el primero termine
        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences(){
        if(preferences.name.isNotEmpty() && preferences.age >=0){
            // hay datos
            textViewSharedPref.text = "Welcome ${preferences.name}, your age is ${preferences.age}."
        }else{
            textViewSharedPref.text = "Welcome. Please save your name and your age"
        }
    }

    private fun setValuesSharedPreferences(){
        if(editTextName.text.toString().isNotEmpty() && editTextAge.text.toString().isNotEmpty()){
            // los campos tienen texto
            preferences.name = editTextName.text.toString()
            preferences.age = editTextAge.text.toString().toInt()
            toast("Values have been saved succesfully")

        }else{
            toast("Please fill the name and the age before saving")

        }
    }

    private fun cleanEditText(){
        editTextAge.text.clear()
        editTextName.text.clear()
    }
}
