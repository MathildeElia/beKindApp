package com.example.kind1

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kind1.data.Organisation
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

data class organisationUiState(
    var organisation: Organisation = Organisation()
)
class Viewmodel : ViewModel() {

    var username = mutableStateOf("")
    var working = mutableStateOf("")

    var organisationState = MutableStateFlow(organisationUiState())


    fun validInput(user: String, pass: String): Boolean {
        if (user == "" || pass == "") {
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
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Log.d("DATABASE status","success")
                }else {
                    Log.d("DATABASE status","fail")
                }
            }
    }


    fun submitError(error: String, user: String) {

        val newError = hashMapOf(
            "errorMessage" to error,
            "user"         to user
        )
        db  .collection("errors")
            .document()
            .set(newError)
            .addOnSuccessListener {  }
            .addOnFailureListener {  }
    }
    // on below line we are calling method to display UI
    //firebaseUI(LocalContext.current, courseList)
    fun getOgFromDatabase(s: String) {

        viewModelScope.launch {
            val organisation = Organisation()
            val db = FirebaseFirestore.getInstance()
            val docRef = db.collection("Organization").document(s)
            docRef.get().addOnSuccessListener { documentSnapshot ->
                organisation.description = documentSnapshot.get("description") as String
                organisation.subheading = documentSnapshot.get("subheading") as String
                organisation.name = documentSnapshot.id
                organisationState.value = organisationState.value.copy(organisation)
                Log.d(TAG, "Organisation $organisation")
            }
        }
    }
}