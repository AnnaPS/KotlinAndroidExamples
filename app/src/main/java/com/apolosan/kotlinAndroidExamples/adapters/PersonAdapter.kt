package com.apolosan.kotlinAndroidExamples.adapters

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.apolosan.kotlinAndroidExamples.R
import com.apolosan.kotlinAndroidExamples.R.layout.list_view_person
import com.apolosan.kotlinAndroidExamples.extensions.inflate
import com.apolosan.kotlinAndroidExamples.models.Person
import kotlinx.android.synthetic.main.list_view_person.view.*

class PersonAdapter (val context: Context, val layout: Int, val list: List<Person>) : BaseAdapter() {


    /**
     * Devuelve el item de la lista
     */
    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    /**
     * Devuelve el numero de items que hay en la lista
     */
    override fun getCount(): Int {
        return list.size
    }

    /**
     * Se llamará cada vez que se tenga que añadir un item a la lista
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: PersonViewHolder

        // La primera vez convertView es nulo
        if(convertView == null){
            view = parent!!.inflate(list_view_person)
            vh = PersonViewHolder(view)
            view.tag = vh // guarda el objeto en el view
        }else{
            view = convertView
            vh = view.tag as PersonViewHolder // recupera el tag anterior
        }

        val fullName = "${list[position].firstName} ${list[position].lastName}"
        vh.fullName.text = fullName
        vh.age.text = "${list[position].age}"

        return view
    }

}

/**
 * Referencia a los componentes del layout
 */
private class PersonViewHolder(view: View){
    val fullName: TextView = view.txtCompleteName
    val age: TextView = view.txtAge
}