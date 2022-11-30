package com.example.kind1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class Viewmodel: ViewModel() {

    var username = mutableStateOf("")
    var working = mutableStateOf("")


    fun validInput(user : String, pass : String): Boolean{
        if(user == "" || pass == ""){
            return false
        }
        return true
    }

}