package com.example.happypet.factory

import android.util.Log

class RedAlert() : Alert {
    override fun owner(name: String) {

    }

    override fun setAddress(email: String) {

    }

    override fun setNote(note: String) {
        Log.d("Red Alert::",note)
    }

    fun setUrgency(level:Int){
        Log.d("Red Alert::",level.toString() )
    }
}