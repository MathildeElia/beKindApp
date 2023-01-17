package com.example.kind1.viewlmodel
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
class VievModelAdmin : ViewModel() {
    private val db = Firebase.firestore
    fun submitCharity(charityName: String, subheading: String, beskrivelse: String, theme: String) {

        val newCharity = hashMapOf(
            "name" to charityName,
            "subheading" to subheading,
            "description" to beskrivelse,
            "theme" to theme
        )
        db.collection("Organization").document(charityName).set(newCharity)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("DATABASE status", "success")
                } else {
                    Log.d("DATABASE status", "fail")
                }
            }
    }
}