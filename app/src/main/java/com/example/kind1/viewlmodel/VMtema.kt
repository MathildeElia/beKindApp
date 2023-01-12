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

    fun getThemeOrg(s: String) {
        val db = FirebaseFirestore.getInstance()

        db.collection("Organization")
            .whereEqualTo("tema", s)
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
