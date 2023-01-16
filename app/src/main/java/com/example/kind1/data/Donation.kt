package com.example.kind1.data

data class Donation(
    val amount: Int = 0,
    val orgName: String = "",
    val username: String = "",
    val isMonthly: Boolean = true
)