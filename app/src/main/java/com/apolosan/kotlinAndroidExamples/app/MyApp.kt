package com.apolosan.kotlinAndroidExamples.app

import android.app.Application
import com.apolosan.kotlinAndroidExamples.others.MySharedPreferences

// Si no se hace uso de las preferencias el codigo que se ponga entre el lazy no será ejecutado.
// Esta variable es global para todas las activities
val preferences: MySharedPreferences by lazy { MyApp.prefs!!}

// Sobreescirbe de Application para conseguir que se "ejecute" logica antes de que el primer activity sea mostrado.
// Se tiene que añadir al manifest android:name=".app.MyApp"
class MyApp : Application() {

    companion object {
        var prefs: MySharedPreferences? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefs = MySharedPreferences(applicationContext)
    }

}