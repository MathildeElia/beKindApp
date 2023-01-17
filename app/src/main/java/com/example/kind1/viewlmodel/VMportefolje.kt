package com.example.kind1.viewlmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kind1.data.Donation
import com.example.kind1.data.Portofolio
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow

data class portefoljeUiState(
    var donList: List<Donation> = listOf<Donation>()
)

class VMportefolje : ViewModel() {
    val themes = listOf("Miljø", "Sundhed", "Dyrevelfærd", "Socialt udsatte")

    val portefoljeState = MutableStateFlow(portefoljeUiState())
    fun getPortefoljeDon(s: String) {
        val db = FirebaseFirestore.getInstance()

        db.collection("Donation")
            .get()
            .addOnSuccessListener { documents ->
                val list = documents.map { document ->

                    val donation = Donation()
                    donation.amount = document.get("amount") as Int
                    donation.username = document.get("username") as String
                    donation.theme = document.get("theme") as String

                    Log.w(ContentValues.TAG, "Donations $donation")

                    donation

                }
                portefoljeState.value = portefoljeState.value.copy(list)
            }
    }

    fun themeSort() {
        val miljø: ArrayList<Donation> = ArrayList()
        val sundhed: ArrayList<Donation> = ArrayList()
        val dyr: ArrayList<Donation> = ArrayList()
        val social: ArrayList<Donation> = ArrayList()

        var curTheme = ""
        val donList = portefoljeState.value.donList
        for (donation in donList) {
            curTheme = donation.theme
            when (curTheme) {
                "Miljø" -> miljø.add(donation)
                "Sundhed" -> sundhed.add(donation)
                "Dyr" -> dyr.add(donation)
                "Social" -> social.add(donation)
            }
        }
        val list: ArrayList<Any?> = ArrayList<Any?>()
        list.add(miljø)
        list.add(sundhed)
        list.add(dyr)
        list.add(social)

        //amount starter på 0
        val amounts = mutableListOf<Int>(0, 0, 0, 0)
        list.forEachIndexed { index, element ->
            val curList = donList

            curList.forEachIndexed { index2, element2 ->
                amounts[index] = amounts[index] + element2.amount
            }
        }
        var miljøPercentage = 0
        var sundhedPercentage = 0
        var dyrPercentage = 0
        var socialPercentage = 0
        if (amounts.sum() > 0) {
            miljøPercentage = (amounts.get(0) / amounts.sum()) * 100
            sundhedPercentage = (amounts.get(1) / amounts.sum()) * 100
            dyrPercentage = (amounts.get(2) / amounts.sum()) * 100
            socialPercentage = (amounts.get(3) / amounts.sum()) * 100
        }
        val portefolje: Portofolio = Portofolio(
            miljøP = miljøPercentage,
            sundhedP = sundhedPercentage, dyrP = dyrPercentage, socialP = socialPercentage
        )

        println("Hej" + portefolje.miljøP)
    }
}

