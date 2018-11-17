package com.apolosan.kotlinAndroidExamples.models

import android.support.v7.widget.Toolbar

interface iToolbar {

    fun toolbarToLoad(toolbar: Toolbar?)
    fun enableHomeDisplay(value: Boolean)
}