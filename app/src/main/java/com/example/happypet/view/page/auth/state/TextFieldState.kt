package com.example.happypet.view.page.auth.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

open class TextFieldState (
    private val validator : (String) -> Boolean ={true},
    private val errorMessage: (String?) -> String
){
    var text by mutableStateOf("")
    var error by mutableStateOf<String?>(null)

    fun validate() {
      error= if(isValid()) null else {errorMessage(text)}
    }

    fun isValid() :Boolean{
        return validator(text)
    }

}


