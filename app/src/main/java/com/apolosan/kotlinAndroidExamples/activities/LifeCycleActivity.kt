package com.apolosan.kotlinAndroidExamples.activities

import android.os.Bundle
import android.os.Handler
import com.apolosan.kotlinAndroidExamples.R
import com.apolosan.kotlinAndroidExamples.extensions.toast
import com.apolosan.kotlinAndroidExamples.others.LifeCycleEventsActivity

/**
 * Hereda de LifeCycleEventsActivity para mostrar mensajes segun ciclo de vida de esta actividad
 */
class LifeCycleActivity : LifeCycleEventsActivity() {

    private var exitEnable = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

    }

    /**
     * Si el usuario pulsa atras, entrará en este metodo y comprobará el valor de la boolean,
     * esta, estará a false. Después la booleana se pondrá a true e informará al usuario que
     * para salir debe volver a pulsar atrás. si lo hace se volverá a llamar al método, pero
     * con la booleana a true y pasará por el if que cerrará esta actividad, si no pulsa el
     * handler a los dos segundos volverá a poner la booleana a false.
     */
    override fun onBackPressed() {
        if(exitEnable){
            super.onBackPressed()
        }
        exitEnable = true
        toast("Para salir vuelva a pulsar")
        // El handler va a ejecutar este codigo al pasar dos segundos.
        Handler().postDelayed({ exitEnable = false }, 2000)

    }
}
