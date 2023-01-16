package com.example.kind1

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.kind1.data.Organisation
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow

data class temaUiState(
    var orgList: List<Organisation> = listOf<Organisation>()
)

class VMtema : ViewModel() {

    val temaState = MutableStateFlow(temaUiState())

    fun getThemeText(theme: String):String{
        var s: String = ""
        when(theme){
            "Miljø" -> s = "Støt organisationer som gør\nsamfundet mere bæredygtigt."
            "Sundhed" -> s = "Sundhed tekst."
            "Dyrevelfærd" -> s = "Dyrevelfærd tekst."
            "Socialt Udsatte" -> s = "Social udsatte tekst."
        }
        return s
    }

    fun getThemeOrg(s: String) {
        val db = FirebaseFirestore.getInstance()

        db.collection("Organization")
            .whereEqualTo("theme", s)
            .get()
            .addOnSuccessListener { documents ->
                val list = documents.map { document ->
                    val organisation = Organisation()

                    organisation.description = document.get("description") as String
                    organisation.subheading = document.get("subheading") as String
                    organisation.name = document.id

                    Log.w(TAG, "Organisations $organisation")

                    organisation

                }
                temaState.value = temaState.value.copy(list)
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }
    }
}
