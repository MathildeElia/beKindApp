package com.example.kind1.data

data class Donation(
    var amount: Long = 0,
    var orgName: String = "",
    var username: String = "",
    var isMonthly: Boolean = true,
    var theme: String = ""
)