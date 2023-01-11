package com.example.kind1

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kind1.data.Organisation
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.system.exitProcess
import kotlinx.coroutines.tasks.await
import java.lang.reflect.Modifier

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

    fun readOrganization(): SnapshotStateList<Organisation?> {
        // A surface container using the 'background' color from the theme

        // on below line creating variable for list of data.
        var organisationList = mutableStateListOf<Organisation?>()
        // on below line creating variable for freebase database
        // and database reference.
        var db: FirebaseFirestore = FirebaseFirestore.getInstance()

        // on below line getting data from our database
        db.collection("Organisation").get()
            .addOnSuccessListener { queryDocumentSnapshots ->
                // after getting the data we are calling
                // on success method
                // and inside this method we are checking
                // if the received query snapshot is empty or not.
                if (!queryDocumentSnapshots.isEmpty) {
                    // if the snapshot is not empty we are
                    // hiding our progress bar and adding
                    // our data in a list.
                    // loadingPB.setVisibility(View.GONE)
                    val list = queryDocumentSnapshots.documents
                    for (d in list) {
                        // after getting this list we are passing that
                        // list to our object class.
                        val c: Organisation? = d.toObject(Organisation::class.java)
                        // and we will pass this object class inside
                        // our arraylist which we have created for list view.
                        organisationList.add(c)
                    }
                } /* else {
                    // if the snapshot is empty we are displaying
                    // a toast message.
                    Toast.makeText(
                        this@CourseDetailsActivity,
                        "No data found in Database",
                        Toast.LENGTH_SHORT
                    ).show()
                }
               */
            }
        return organisationList
        /*
    // if we don't get any data or any error
    // we are displaying a toast message
    // that we do not get any data
    .addOnFailureListener {
        Toast.makeText(
            this@CourseDetailsActivity,
            "Fail to get the data.",
            Toast.LENGTH_SHORT
        ).show() */
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


