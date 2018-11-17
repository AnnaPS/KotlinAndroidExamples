package com.apolosan.kotlinAndroidExamples.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Button
import com.apolosan.kotlinAndroidExamples.R
import com.apolosan.kotlinAndroidExamples.extensions.toast
import com.apolosan.kotlinAndroidExamples.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent_extra.*
import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*

class KotlinAndroidExtensionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extensions)

        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener { toast("Click by Id") }


        /**
         * Al hacer el siguiente import : import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*
         * podemos usar los id de los botones en este caso si necesidad de usar el findViewById
         */
        buttonByKotlinAndroidExtension.setOnClickListener { toast("Click by KAT") }
    }
}