package com.apolosan.kotlinAndroidExamples.activities

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.apolosan.kotlinAndroidExamples.R
import com.apolosan.kotlinAndroidExamples.extensions.toast
import kotlinx.android.synthetic.main.activity_permisions.*


class PermisionsActivity : AppCompatActivity() {

    private val requestCodePermission = 100
    private val requestCameraPicture = 50
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permisions)

        buttonPicture.setOnClickListener{getPictureFromCameraAskingPermissions()}

    }
    private fun getPictureFromCameraAskingPermissions(){

        //Añadir permiso al manifest
        //Comprobar el permiso de la camara
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //Si no ha sido aceptado previamente (Para versiones desde la 6.0 [API 23] en adelante) le pedimos los permisos
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),requestCodePermission)

        }else{
            //Si ha sido aceptado previamente (Para las versiones inferiores a la 6.0, ya que se acpetan al instalar la app)
            val intent = takePhoto()
            startActivityForResult(intent, requestCameraPicture)
        }
    }

    /**
     * Controla que el cuadro de texto del permiso sea respondido.
     * Se controla gracias al requestCode que se asigna en el metodo anterior
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode){
            requestCodePermission -> {
                if(grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //permiso aceptado
                    val intent = takePhoto()
                    startActivityForResult(intent, requestCameraPicture)
                }else{
                    // permiso denegado
                    toast("Permiso denegado, no puede tomar la foto")
                }
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when(requestCode){
            requestCameraPicture ->{
                //Comproar si el resultado es bueno
                if(resultCode == Activity.RESULT_OK){
                    //Obtenemos los extras del intent recibido por parametros
                    val extras = data!!.extras
                    //Formar el bitmap a partir de los extras.
                    val imageBitMap = extras.get("data") as Bitmap
                    //Cargar la foto como bitmap en el imageView
                    imageViewPicture.setImageBitmap(imageBitMap)
                }else{
                    //La foto no se ha realizado con exito
                    toast("No se ha podido cargar la foto")
                }
            }
        }
    }



    private fun takePhoto(): Intent{
        return Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    }
}
