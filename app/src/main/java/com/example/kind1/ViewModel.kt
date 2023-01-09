package com.example.kind1

import android.graphics.Color
import android.view.Surface
import android.widget.Toast
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.ViewModel
import com.example.kind1.data.Organisation
import com.example.kind1.data.User
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.lang.reflect.Modifier

class Viewmodel : ViewModel() {

    var username = mutableStateOf("")
    var working = mutableStateOf("")


    fun validInput(user: String, pass: String): Boolean {
        if (user == "" || pass == "") {
            return false
        }
        return true
    }

    fun validInputSign(user: String, pass: String, email: String): Boolean {
        if (user == "" || pass == "" || !(email.contains("@gmail.com") || email.contains("@gmail.dk"))) {
            return false
        }
        return true
    }


    fun addToDatabase(user: String, pass: String, email: String) {

        val db = Firebase.firestore

        val newUser2 = User(user, pass, email)

        val newUser = hashMapOf(
            "username" to user,
            "password" to pass,
            "email" to email
        )
        //db.document().set(newUser2)
        db.collection("users")
            .add(newUser)
        /*
     db.collection("users")
         .add(newUser)

         .addOnSuccessListener { documentReference ->
             Log.d(
                 ContentValues.TAG,
                 "DocumentSnapshot added with ID: ${documentReference.id}"
             )
         }
         .addOnFailureListener { e ->
             Log.w(ContentValues.TAG, "Error adding document", e)
         }
         .addOnCompleteListener {
             Log.d("Test", "Is success: ${it.isSuccessful}")
         }
              */

    }

    fun readOrganization() {
        // A surface container using the 'background' color from the theme

        // on below line creating variable for list of data.
        var courseList = mutableStateListOf<Organisation?>()
        // on below line creating variable for freebase database
        // and database reference.
        var db: FirebaseFirestore = FirebaseFirestore.getInstance()

        // on below line getting data from our database
        db.collection("Courses").get()
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
                        courseList.add(c)

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
}

