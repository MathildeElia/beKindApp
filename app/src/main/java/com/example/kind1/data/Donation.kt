package com.example.kind1.data

data class Donation(
    var amount: Long = 0,
    val orgName: String = "",
    var username: String = "",
    val isMonthly: Boolean = true,
    var theme: String = ""
)