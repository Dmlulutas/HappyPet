package com.example.happypet.factory

import android.util.Log

interface Alert {
    public fun setAddress(email: String)
    public fun setNote(note:String)

    public fun createAlert() {
        Log.d("Alert::", "Create a alert")
    }
}