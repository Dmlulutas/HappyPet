package com.example.happypet.factory

import android.util.Log

class GreenAlert() : Alert {
    override fun setAddress(email: String) {

    }

    override fun setNote(note: String) {

    }

    fun setHelpType(type: HelpType) {
        Log.d("Green Alert:", type.toString())
    }

}