package com.example.happypet.factory

import android.util.Log

interface Alert {

    fun owner(name:String)
    fun setAddress(email: String)
    fun setNote(note: String)

    fun createAlert() {
        Log.d("Alert::", "Create a alert")
    }
}