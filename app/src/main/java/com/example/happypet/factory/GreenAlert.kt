package com.example.happypet.factory

import android.util.Log
import com.example.happypet.model.enums.HelpType

class GreenAlert() : Alert {
    override fun owner(name: String) {

    }

    override fun setAddress(email: String) {

    }

    override fun setNote(note: String) {

    }

    fun setHelpType(type: HelpType) {
        Log.d("Green Alert:", type.toString())
    }

}