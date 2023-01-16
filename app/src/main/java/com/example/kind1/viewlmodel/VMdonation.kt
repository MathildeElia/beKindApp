package com.example.kind1.viewlmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kind1.data.Donation
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class VMdonation : ViewModel() {

    private val db = Firebase.firestore

    fun addDonationToDatabase(donation: Donation) {

        db.collection("users").document(donation.username).set(donation)
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

        db.collection("Organization").document(donation.orgName)
            .collection("donations").document(donation.username).set(donation)
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