package com.example.kind1.viewlmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kind1.data.Donation
import com.example.kind1.data.Organisation
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

data class Liststate(
    var donList: List<Donation> = listOf<Donation>()
)
data class NewsUiState(
    var organisation: Organisation = Organisation()
)
class VMstart : ViewModel() {
    val liststate = MutableStateFlow(Liststate())
    val newsstate = MutableStateFlow(NewsUiState())

    fun getDonations(s: String) {

        val db = FirebaseFirestore.getInstance()

        db.collection("users").document(s).collection("donations").get()
            .addOnSuccessListener { documents ->
                val list = documents.map { document ->
                    val donation = Donation()

                    donation.amount = document.get("amount") as Long
                    donation.username = document.get("username") as String
                    donation.theme = document.get("theme") as String
                    donation.orgName = document.get("orgName") as String

                    Log.w(ContentValues.TAG, "Organisations $donation")
                    donation
                }
                liststate.value = liststate.value.copy(list)
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents: ", exception)
            }
    }
    fun numberOfThemeAndOrg(): List<Int> {
        val themeList = mutableListOf<String>()
        val orgList = mutableListOf<String>()

        //Initializing counters
        var themeC = 0;
        var orgC = 0

        var monthlyAmount = 0

        val donList = liststate.value.donList
        for (don in donList) {

            //if the donation is not monthly,
            //it will not be a part of the portfolio
            if (!don.isMonthly) {
                continue
            }

            monthlyAmount = (monthlyAmount + don.amount).toInt()

            if (don.theme !in themeList) {
                themeList.add(don.theme)
                themeC++
            }
            if (don.orgName !in orgList) {
                orgList.add(don.orgName)
                orgC++
            }
        }
        return listOf(themeC, orgC, monthlyAmount)
    }

    fun getNews(orgName: String) {
        viewModelScope.launch {
            val organisation = Organisation()
            val db = FirebaseFirestore.getInstance()
            val docRef = db.collection("Organization").document(orgName)
            docRef.get().addOnSuccessListener { documentSnapshot ->

                organisation.news = documentSnapshot.get("nyheder") as? String
                newsstate.value = newsstate.value.copy(organisation)
                Log.d(ContentValues.TAG, "Organisation $organisation")
            }
        }
    }
}
