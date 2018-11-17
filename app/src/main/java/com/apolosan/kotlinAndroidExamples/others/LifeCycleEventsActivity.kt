package com.apolosan.kotlinAndroidExamples.others

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.apolosan.kotlinAndroidExamples.extensions.toast

open class LifeCycleEventsActivity : AppCompatActivity() {

    /**
     * Muestra mensajes segun en el ciclo de vida que se encuentre el activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toast("ON CREATE")
    }

    override fun onStart() {
        super.onStart()
        toast("ON START")
    }

    override fun onResume() {
        super.onResume()
        toast("ON RESUME")

    }

    override fun onPause() {
        super.onPause()
        toast("ON PAUSE")

    }

    override fun onStop() {
        super.onStop()
        toast("ON STOP")

    }

    override fun onDestroy() {
        super.onDestroy()
        toast("ON DESTROY")

    }
}
