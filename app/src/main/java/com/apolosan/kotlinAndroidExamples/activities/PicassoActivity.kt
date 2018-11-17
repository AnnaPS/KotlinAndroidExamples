package com.apolosan.kotlinAndroidExamples.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.telecom.Call
import com.apolosan.kotlinAndroidExamples.R
import com.apolosan.kotlinAndroidExamples.extensions.toast
import com.apolosan.kotlinAndroidExamples.others.ToolbarActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_intent_extra.*
import kotlinx.android.synthetic.main.activity_picasso.*

class PicassoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)


        /**
         *  Si queremos cargar varias imagenes y queremos que sea más rápido, podemos pre- cachear
         *  las imgs con fetch.
         *  Si queremos ver si estan en cache al pasar por está linea lo podemos ver desde
         *  View -> Tools Windows -> Device File Explorer -> data -> data->
         *  com.nuestro_nombre.nombre_app -> cache -> picasso-cache
         *  En esa ruta deberán aparecer ficheros del estilo db451b564a21654f5s56.
         */

        buttonLoader.setOnClickListener { loadImages() }

        Picasso.with(this).load("https://static.pexels.com/photos/216264/pexels-photo-216264.jpeg").fetch()
    }

    /**
     *   -.fit() le decimos que ocupe todo el espacio del image view
     *   - Resize() + centerInside() -> renderiza la imagen a las medidas y lo cuadra dentro del imageView
     *   - Resize() + centerCrop()-> renderiza a las medidas y lo deja centrado
     *   -Transform(CircleTransform) -> renderiza con forma de circulo, usamos la clase CircleTransform que está desarrollada por un
     *   desarrollador de android
     **/

    fun loadImages() {
        Picasso
                .with(this)
                .load("https://static.pexels.com/photos/216264/pexels-photo-216264.jpeg")
                .fit()
                .into(imageViewTop)
        /* Picasso
                 .with(this)
                 .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                 .resize(400, 400)
                 .centerInside()
                 .into(imageViewBottom)*/

        /* Picasso
                 .with(this)
                 .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                 .fit()
                 .transform(CircleTransform())
                 .into(imageViewBottom) */

        val context : Context = this

        Picasso.with(this)
                .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                .fetch(object : Callback{
                    override fun onSuccess() {
                        // Si se carga la imagen bien
                        imageViewBottom.alpha = 0f // invisible
                        Picasso.with(context) // usamos el context creado anteriormente porque estamos dentro del contexto del callback
                                .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                                .fit()
                                .into(imageViewBottom)
                        imageViewBottom.animate().setDuration(1300).alpha(1f).start() // hace una animacion de tipo "fade" y lo hace visible
                    }

                    override fun onError() {
                        //Si falla
                        toast("Algo salió mal al cargar la foto con Picasso")
                     }

                })


    }
}
