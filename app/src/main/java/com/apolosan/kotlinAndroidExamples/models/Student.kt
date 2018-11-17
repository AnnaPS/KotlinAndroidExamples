package com.apolosan.kotlinAndroidExamples.models

import android.os.Parcel
import android.os.Parcelable

data class Student(var name: String, var lastName: String, var age: Int, var developer: Boolean = true) : Parcelable {

    /**
     * Parcel es un contendor para un mensaje
     *  Puede ser usado para mandar un objeto serializado a traves de intent
     *  Mejor rendimiento que Serializer
     */

    constructor(parcel: Parcel) : this(
            //Lee en el mismo orden que la declaracion de propiedades
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        //Escribe los valores en el mismo orden que en el constructor
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if (developer) 1 else 0)
    }

    //Describe el tipo de contenido del objeto parcelable.
    //0 siempre se usa, el otro valor es 1 o CONTENTS_FILE_DESCRIPTOR (para tipos de objetos que implementa un File Descriptor)
    override fun describeContents(): Int {
        return 0
    }


    companion object CREATOR : Parcelable.Creator<Student> {
        //Esto creará el objeto desde el Parcel llamando al constructor secundario
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        //Esto ayudará a serializar arrays de objetos del mismo tipo que la clase en cuestion (Student en este caso)
        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}