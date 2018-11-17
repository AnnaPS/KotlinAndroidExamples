package com.apolosan.kotlinAndroidExamples.others

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.apolosan.kotlinAndroidExamples.models.iToolbar

/**
 * clase para poder utilizar el toolbar en cualquier activity de una manera mas comoda
 */


open class ToolbarActivity : AppCompatActivity() , iToolbar {
    protected var _toolbar: Toolbar? = null

    override fun toolbarToLoad(toolbar: Toolbar?) {
        _toolbar = toolbar
        _toolbar?.let{setSupportActionBar(_toolbar)} //si no es nulo se le pasa el toolbar
    }

    override fun enableHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }



}
