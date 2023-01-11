package com.example.kind1

import android.content.ContentValues
import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

class Viewmodel: ViewModel() {

    var username = mutableStateOf("")
    var working = mutableStateOf("")


    fun validInput(user : String, pass : String): Boolean{
        if(user == "" || pass == ""){
            return false
        }
        return true
    }

    fun validInputSign(user : String, pass : String,email : String): Boolean{
        if(user == "" || pass == "" || !(email.contains("@") || email.contains("."))){
           return false
        }

        return true
    }

    private val db = Firebase.firestore



    fun addToDatabase(user: String, pass: String, email: String) {

            val newUser = hashMapOf(
                "username" to user,
                "password" to pass,
                "email" to email
            )





        db.collection("users").document(user).set(newUser)
         .addOnSuccessListener { documentReference ->
             Log.d(
                 ContentValues.TAG,
                 "DocumentSnapshot added with ID: $documentReference."
             )
         }
         .addOnFailureListener { e ->
             Log.w(ContentValues.TAG, "Error adding document", e)
         }
         .addOnCompleteListener {
             Log.d("Test", "Is success: ${it.isSuccessful}")
         }
    }

}