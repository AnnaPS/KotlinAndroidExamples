package com.apolosan.kotlinAndroidExamples.others

import android.content.Context

class MySharedPreferences(context: Context) {

    //Nombre fichero shared preferences
    private val fileName = "mis_preferencias"

    //Instancia del fichero
    val prefs = context.getSharedPreferences(fileName, Context.MODE_PRIVATE) // Con mode_private conseguimos que solo lea el fichero nuestra app y no lo hagan de terceros

    // Por cada una de las variables que se guardan en el fichero
    var name: String
        get() = prefs.getString("name","")
        set(value) = prefs.edit().putString("name",value).apply()

    var age: Int
        get() = prefs.getInt("age",-1)
        set(value) = prefs.edit().putInt("age",value).apply()

}