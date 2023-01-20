package com.example.kind1.viewlmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kind1.data.Donation
import com.example.kind1.data.Organisation
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

data class organisationState(
    var organisation: Organisation = Organisation()
)
data class errorState(
    var error: Boolean = false
)
class VMdonation : ViewModel() {
    var organisationState = MutableStateFlow(organisationState())
    var errorState = MutableStateFlow(errorState())


    private val db = Firebase.firestore
    val hasError = false
    init {

    }

    fun isMonthly(s: String): Boolean {
        if (s.equals("Støt månedligt")) {
            return true
        }
        return false
    }

    fun findOrgTheme(orgName: String) : String {
        var theme = ""
        viewModelScope.launch {
            val db = FirebaseFirestore.getInstance()
            val docRef = db.collection("Organization").document(orgName)
            theme = docRef.get().await().data?.get("theme") as String
        }
        return theme
    }

    fun addDonationToDatabase(donation: Donation) {
        viewModelScope.launch {

            val db = FirebaseFirestore.getInstance()
            val docRef = db.collection("Organization").document(donation.orgName)
            donation.theme = docRef.get().await().data?.get("theme") as String

            db.collection("users").document(donation.username)
                .collection("donations").document(donation.orgName).set(donation)
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
}

