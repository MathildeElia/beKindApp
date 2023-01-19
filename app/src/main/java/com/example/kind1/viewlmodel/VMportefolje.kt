package com.example.kind1.viewlmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kind1.data.Donation
import com.example.kind1.data.Portofolio
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.math.roundToInt


data class PortefoljeUiState(
    var portefoljeUi: Portofolio = Portofolio()
)

data class ListState(
    var donList: List<Donation> = listOf<Donation>()
)

class VMportefolje : ViewModel() {

    val listState = MutableStateFlow(ListState())
    val portefoljeState = MutableStateFlow(PortefoljeUiState())


    fun getPortefoljeDon(s: String) {

        val db = FirebaseFirestore.getInstance()

        //where isMonthly is true!!
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
                listState.value = listState.value.copy(list)
                themeSort()
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents: ", exception)
            }
    }

    fun themeSort() {
        val miljø: ArrayList<Donation> = ArrayList()
        val sundhed: ArrayList<Donation> = ArrayList()
        val dyr: ArrayList<Donation> = ArrayList()
        val social: ArrayList<Donation> = ArrayList()

        var curTheme = ""
        val donList = listState.value.donList
        for (donation in donList) {
            curTheme = donation.theme
            when (curTheme) {
                "Miljø" -> miljø.add(donation)
                "Sundhed" -> sundhed.add(donation)
                "Dyrevelfærd" -> dyr.add(donation)
                "Socialt Udsatte" -> social.add(donation)
            }
        }
        val list: ArrayList<Any?> = ArrayList<Any?>()
        list.add(miljø)
        list.add(sundhed)
        list.add(dyr)
        list.add(social)

        calculatePercentages(donList)
    }

    fun calculatePercentages(donList: List<Donation>){
        //amount starter på 0
        val amounts = mutableListOf<Int>(0, 0, 0, 0)
        donList.forEachIndexed { index, element ->
            val curDon = donList.get(index)
            when (curDon.theme) {
                "Miljø" -> amounts[0] = (amounts[0] + curDon.amount).toInt()
                "Sundhed" -> amounts[1] = (amounts[1] + curDon.amount).toInt()
                "Dyrevelfærd" -> amounts[2] = (amounts[2] + curDon.amount).toInt()
                "Socialt Udsatte" -> amounts[3] = (amounts[3] + curDon.amount).toInt()
            }
        }
        var miljøPercentage = 0
        var sundhedPercentage = 0
        var dyrPercentage = 0
        var socialPercentage = 0

        var sum = 0
        amounts.forEachIndexed { index, element ->
            sum += element
        }

        //Calculates percentage
        if (amounts.sum() > 0) {
            miljøPercentage = ((amounts[0].toDouble() / amounts.sum()) * 100).roundToInt()
            sundhedPercentage = ((amounts[1].toDouble() / amounts.sum()) * 100).roundToInt()
            dyrPercentage = ((amounts[2].toDouble() / amounts.sum()) * 100).roundToInt()
            socialPercentage = ((amounts[3].toDouble() / amounts.sum()) * 100).roundToInt()
        }
        val portefolje: Portofolio = Portofolio(
            miljøP = miljøPercentage,
            sundhedP = sundhedPercentage, dyrP = dyrPercentage, socialP = socialPercentage
        )
        portefoljeState.value.portefoljeUi = portefoljeState.value.portefoljeUi
            .copy(portefolje.miljøP, portefolje.sundhedP, portefolje.dyrP, portefolje.socialP)
    }

    fun numberOfThemeAndOrg(): List<Int> {
        val themeList = mutableListOf<String>()
        val orgList = mutableListOf<String>()

        //Initializing counters
        var themeC = 0;
        var orgC = 0

        val donList = listState.value.donList
        for (don in donList) {

            //if the donation is not monthly,
            //it will not be a part of the portfolio
            if (!don.isMonthly) {
                continue
            }
            if (don.theme !in themeList) {
                themeList.add(don.theme)
                themeC++
            }
            if (don.orgName !in orgList) {
                orgList.add(don.orgName)
                orgC++
            }
        }
        return listOf(themeC, orgC)
    }
}

