package com.apolosan.kotlinAndroidExamples.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.apolosan.kotlinAndroidExamples.R
import com.apolosan.kotlinAndroidExamples.models.Student
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)




        //listeners botones
        buttonIntentExtras.setOnClickListener{ goIntentsExtra() }
        buttonIntentFlags.setOnClickListener{ goIntentsFlags() }
        buttonIntentObject.setOnClickListener{ goIntentsObject() }
    }

    private fun goIntentsExtra(){
        val intent = Intent(this, IntentExtraActivity:: class.java)
        intent.putExtra("name","Ana")
        intent.putExtra("lastName","Herron")
        intent.putExtra("age",27)
        intent.putExtra("developer",true)
        startActivity(intent)
    }

    private fun goIntentsFlags(){
        val intent = Intent(this, IntentExtraActivity:: class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY //no guarda el activity en el stack. Equivalente a finish()
        intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION //no animacion
        //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK //vacia el stack (pila) completo

        startActivity(intent)
    }
    private fun goIntentsObject(){
        val intent = Intent(this, IntentExtraActivity:: class.java)

        val student = Student("Lucia", "Polo",25,false)
        intent.putExtra("student", student)

        startActivity(intent)
    }
}
