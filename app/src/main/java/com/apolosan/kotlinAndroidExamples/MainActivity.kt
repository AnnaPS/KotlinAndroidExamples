package com.apolosan.kotlinAndroidExamples

import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.widget.Button

import com.apolosan.kotlinAndroidExamples.activities.*
import com.apolosan.kotlinAndroidExamples.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : ToolbarActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       toolbarToLoad(toolbar as Toolbar)


        val btnLifeCycle = findViewById<Button>(R.id.button_to_cycle)
        val btnExtensionsFunctions = findViewById<Button>(R.id.button_to_extension_functions)
        val btnIntents = findViewById<Button>(R.id.button_to_intents)
        val btnKotlinAndroidExtensions = findViewById<Button>(R.id.button_to_android_extensions)
        val btnClickEvents= findViewById<Button>(R.id.button_to_click)
        val btnListView = findViewById<Button>(R.id.button_to_list_view)
        val btnPermissions = findViewById<Button>(R.id.button_to_permissions)
        val btnPicasso = findViewById<Button>(R.id.button_to_picasso)
        val btnSharedPreferences = findViewById<Button>(R.id.button_to_shared_preferences)


        btnLifeCycle.setOnClickListener{goToLifeCycleActivity()}
        btnClickEvents.setOnClickListener{goToClickEventsActivity()}
        btnKotlinAndroidExtensions.setOnClickListener{goToKotlinAndroidExtensionsActivity()}
        btnPicasso.setOnClickListener{goToPicassoActivity()}
        btnListView.setOnClickListener{goToListViewActivity()}
        btnIntents.setOnClickListener{goToIntentsActivity()}
        btnPermissions.setOnClickListener{goToPermissionsActivity()}
        btnSharedPreferences.setOnClickListener{goToSharedPreferencesActivity()}
        btnExtensionsFunctions.setOnClickListener{goToExtensionsFunctionsActivity()}

    }


    private fun goToLifeCycleActivity() = startActivity(Intent(this, LifeCycleActivity::class.java))
    private fun goToClickEventsActivity() = startActivity(Intent(this, ClickEventsActivity::class.java))
    private fun goToKotlinAndroidExtensionsActivity() = startActivity(Intent(this, KotlinAndroidExtensionsActivity::class.java))
    private fun goToPicassoActivity() = startActivity(Intent(this, PicassoActivity::class.java))
    private fun goToListViewActivity() = startActivity(Intent(this, ListViewActivity::class.java))
    private fun goToIntentsActivity() = startActivity(Intent(this, IntentsActivity::class.java))
    private fun goToPermissionsActivity() = startActivity(Intent(this, PermisionsActivity::class.java))
    private fun goToSharedPreferencesActivity() = startActivity(Intent(this, SharedPreferencesActivity::class.java))
    private fun goToExtensionsFunctionsActivity() = startActivity(Intent(this, ExtensionsFunctionsActivity::class.java))





    fun showSnackBar(){
        val layout =  findViewById<ConstraintLayout>(R.id.constraint)
        Snackbar.make(layout,"Mensaje borrado",Snackbar.LENGTH_LONG).setAction("Deshacer"){
            Snackbar.make(layout,"Deshecho",Snackbar.LENGTH_LONG).show()
        }.show()
    }
}
