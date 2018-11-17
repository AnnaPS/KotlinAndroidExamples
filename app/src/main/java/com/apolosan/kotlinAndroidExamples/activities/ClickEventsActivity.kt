package com.apolosan.kotlinAndroidExamples.activities
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import android.view.View
import android.widget.Button

import com.apolosan.kotlinAndroidExamples.R
import com.apolosan.kotlinAndroidExamples.extensions.toast
import com.apolosan.kotlinAndroidExamples.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*

class ClickEventsActivity : AppCompatActivity() , View.OnLongClickListener{


    // 1) Click en XML
    // 2) Click en linea
    // 3) Clicks by IDS en when


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events)

        // Ejecuta el onClick de In Line
        clickInLine()


        //Recoge los botones Multi
        val btn1 = findViewById<Button>(R.id.buttonClickMulti1)
        val btn2 = findViewById<Button>(R.id.buttonClickMulti2)
        val btn3 = findViewById<Button>(R.id.buttonClickMulti3)

        // Click largo para los multi
        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)
    }

    /**
     *  Reglas obligatorias para clicks en XML.
     *  - El método tiene que ser público
     *  - Los nombres tienen que coincidir
     *  - Recibe un solo parámetro que es un View
     **/


    fun xmlClick(view: View){
        toast("Click by XML")
    }

    private fun clickInLine(){
        val btn = findViewById<Button>(R.id.buttonClickXML)
        btn.setOnClickListener{toast("Click in Line")}
    }

    override fun onLongClick(view: View): Boolean {
        when(view.id){
            R.id.buttonClickMulti1 ->  toast("Multi 1")
            R.id.buttonClickMulti2 ->  toast("Multi 2")
            R.id.buttonClickMulti3 ->  toast("Multi 3")

        }
        return true
    }

}
