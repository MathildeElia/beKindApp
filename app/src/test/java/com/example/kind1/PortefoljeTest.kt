package com.example.kind1

import com.example.kind1.data.Donation
import com.example.kind1.data.Portofolio
import org.junit.Assert
import org.junit.Test
import kotlin.math.roundToInt

class PortefoljeTest {

    //hardcoded donation-list to test on
    val donList = listOf(
        Donation(orgName = "WWF", amount = 50, theme = "Miljø"),
        Donation(orgName = "Læger uden Grænser", amount = 150, theme = "Sundhed"),
        Donation(orgName = "Anima", amount = 50, theme = "Dyrevelfærd", isMonthly = false),
        Donation(orgName = "Plant et Træ", amount = 10, theme = "Miljø")
    )

    //test procent regner
    @Test
    fun percentages_isCorrect() {

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
        //expected results have been calculated with a calculator
        Assert.assertEquals(23, portefolje.miljøP)
        Assert.assertEquals(19, portefolje.dyrP)
        Assert.assertEquals(0, portefolje.socialP)
        Assert.assertEquals(58, portefolje.sundhedP)
    }

    //tester om themaer bliver puttet i r
    @Test
    fun themeSort_isCorrect() {
        val miljø: ArrayList<Donation> = ArrayList()
        val sundhed: ArrayList<Donation> = ArrayList()
        val dyr: ArrayList<Donation> = ArrayList()
        val social: ArrayList<Donation> = ArrayList()

        var curTheme = ""
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

        Assert.assertEquals(
            listOf(
                Donation(orgName = "WWF", amount = 50, theme = "Miljø"),
                Donation(orgName = "Plant et Træ", amount = 10, theme = "Miljø")
            ), list[0]
        )

        Assert.assertEquals(
            listOf(
                Donation(orgName = "Læger uden Grænser", amount = 150, theme = "Sundhed"),
            ), list[1]
        )
        Assert.assertEquals(
            listOf(
                Donation(orgName = "Anima", amount = 50, theme = "Dyrevelfærd", isMonthly = false)
            ), list[2]
        )
        val emptylist: List<Donation> = listOf()
        Assert.assertEquals(emptylist, list[3])
    }

    //Tests if the correct number of themes and organisations
    //is calculated. Is both used in VMportfolje and VMstart.
    @Test
    fun numberOfThemeAndOrgTest() {
        val themeList = mutableListOf<String>()
        val orgList = mutableListOf<String>()

        //Initializing counters
        var themeC = 0;
        var orgC = 0

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
        //return listOf(themeC, orgC)
        Assert.assertEquals(2, themeC)
        Assert.assertEquals(3, orgC)
    }
}