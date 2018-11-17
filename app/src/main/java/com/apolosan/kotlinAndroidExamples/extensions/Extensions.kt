package com.apolosan.kotlinAndroidExamples.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.design.widget.Snackbar
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.apolosan.kotlinAndroidExamples.R
import com.squareup.picasso.Picasso


// comprobar numeros naturales

fun Int.isNatural() = this >= 0

// Metodos para toast
fun Activity.toastLong(message: CharSequence, duration: Int = Toast.LENGTH_LONG) = Toast.makeText(this, message, duration).show()

fun Activity.toastResourceId(resourceId: Int, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, resourceId, duration).show()

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

// Mostrar snackbar con mensaje y accion
// action tiene una funcion vacia, pero si le pasamos un action ejecutará el actionEv
fun Activity.snackBar(message: CharSequence, view: View? = findViewById(R.id.container),
                      duration: Int = Snackbar.LENGTH_SHORT, action: String? = null,
                      actionEv: (v: View) -> Unit = {}) {
    if (view != null) {
        val snackBar = Snackbar.make(view, message, duration)
        if (!action.isNullOrEmpty()) {
            snackBar.setAction(action, actionEv)
        }
        snackBar.show()
    }
}

// metodo inflate para los recyclerViews
// ponemos !! al final porque sabemos que nunca será nulo
fun ViewGroup.inflate(layoutId: Int) = android.view.LayoutInflater.from(context).inflate(layoutId, this, false)!!

// cargar imagenes mediante Url con Picasso
fun ImageView.loadUrl(url: String) = Picasso.with(context).load(url).into(this)

// metdo para cambiar de activities. Entre los parentesis se está restringiendo que se puedan utilizar los metodos de Intent, como son los extras para mandar datos.
inline fun <reified T : Activity> Activity.goToActivity(noinline init: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java)
    intent.init()
    startActivity(intent)
}

fun Activity.goToActivityResult(action: String,requestCode: Int, init: Intent.() -> Unit = {}){
    val intent = Intent(action)
    intent.init()
    startActivityForResult(intent, requestCode)
}

