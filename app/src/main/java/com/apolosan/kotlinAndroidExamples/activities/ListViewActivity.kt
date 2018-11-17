package com.apolosan.kotlinAndroidExamples.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.apolosan.kotlinAndroidExamples.R
import com.apolosan.kotlinAndroidExamples.adapters.PersonAdapter
import com.apolosan.kotlinAndroidExamples.models.Person
import com.apolosan.kotlinAndroidExamples.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent_extra.*
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    private lateinit var adapter: PersonAdapter
    private lateinit var personList: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        personList= getPersons()

        adapter = PersonAdapter(this, R.layout.list_view_person, personList)
        listView.adapter = adapter

    }

    private fun getPersons(): List<Person>{
        val listOfPeople = listOf(
                Person("Ana", "García", 29),
                Person("Lucía", "Pérez", 24),
                Person("Carlos", "Sánchez", 22),
                Person("Juan Manuel", "Conde", 33),
                Person("Manuel", "López", 36),
                Person("Jesús", "Torres", 18),
                Person("Antonio", "Gutierrez", 40)

        )
        return listOfPeople
    }
}
