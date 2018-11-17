package com.apolosan.kotlinAndroidExamples.activities

import android.content.Intent

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.apolosan.kotlinAndroidExamples.R
import com.apolosan.kotlinAndroidExamples.models.Student
import com.apolosan.kotlinAndroidExamples.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent_extra.*

class IntentExtraActivity : ToolbarActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extra)


        //activamos la opcion de que si da hacia atras (flecha en toolbar) vuelva al activity main, se configuró con meta data en el Manifest

        toolbarToLoad(_toolbar as Toolbar)
        enableHomeDisplay(true)


        //si pulsamos atras, volverá al activity anterior que es el de IntentsActiviy
        buttonGoBack.setOnClickListener{startActivity(Intent(this,IntentsActivity::class.java))}

        val isExtrasSet = setIntentExtrasFromPreviousActivity()
        val isParcelableSet =setIntentStudentObjectWithParcelable()

        //Si los dos son falsos lo hace invisible
        if(!isExtrasSet && !isParcelableSet){
            checkBoxDeveloper.visibility = View.INVISIBLE
        }


    }


    private fun setIntentExtrasFromPreviousActivity() : Boolean{
        val name = intent.getStringExtra("name")
        val lastName = intent.getStringExtra("lastName")
        val age: Int = intent.getIntExtra("age",-1) //el valor por defecto en el caso de que age no sea devuelto o no tenga valor
        val developer = intent.getBooleanExtra("developer", false)

        if(name != null && lastName != null && age >=0){
            textViewName.text = name
            textViewLastName.text = lastName
            textViewAge.text = age.toString()
            checkBoxDeveloper.text="Are u a developer?"
            checkBoxDeveloper.isChecked = developer
        }
        return false
    }

    private fun setIntentStudentObjectWithParcelable() : Boolean{
        val student = intent.getParcelableExtra<Student>("student")

        //Comprueba si student es diferente de null
        student?.let {
            textViewName.text = student.name
            textViewLastName.text = student.lastName
            textViewAge.text = student.age.toString()
            checkBoxDeveloper.text="Are u a developer?"
            //checkBoxDeveloper.isChecked = student.developer

        }
        return true
    }
}
