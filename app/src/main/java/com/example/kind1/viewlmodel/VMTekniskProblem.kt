package com.example.kind1.viewlmodel

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class VMTekniskProblem {

    private val db = Firebase.firestore

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


}