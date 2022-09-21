package com.example.happypet.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    var params by mutableStateOf("")

    fun changeParams(value:String){
        params =  value
    }
}