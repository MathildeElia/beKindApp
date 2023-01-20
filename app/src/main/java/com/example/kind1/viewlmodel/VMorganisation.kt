package com.example.kind1.viewlmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kind1.data.Organisation
import com.example.kind1.organisationUiState
import com.google.android.gms.common.config.GservicesValue.value
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

data class organisationUiState(
    var organisation: Organisation = Organisation()
)

class VMorganisation : ViewModel() {

    var organisationState = MutableStateFlow(organisationUiState())


    fun getOgFromDatabase(s: String) {

        viewModelScope.launch {
            val organisation = Organisation()
            val db = FirebaseFirestore.getInstance()
            val docRef = db.collection("Organization").document(s)
            docRef.get().addOnSuccessListener { documentSnapshot ->
                organisation.description = documentSnapshot.get("description") as String
                organisation.subheading = documentSnapshot.get("subheading") as String
                organisation.theme = documentSnapshot.get("theme") as String
                organisation.news = documentSnapshot.get("nyheder") as? String
                organisation.name = documentSnapshot.id
                organisation.link = documentSnapshot.get("link") as? String
                organisationState.value = organisationState.value.copy(organisation)
                Log.d(ContentValues.TAG, "Organisation $organisation")
            }
        }
    }

}

