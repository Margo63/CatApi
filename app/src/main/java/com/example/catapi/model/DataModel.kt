package com.example.catapi.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DataModel:ViewModel() {
    var login by mutableStateOf("")

    fun onLoginChange(newlogin:String){
        login=newlogin
    }

}