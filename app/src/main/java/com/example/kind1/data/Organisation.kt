package com.example.kind1.data

data class Organisation(
    // on below line creating variables.
    var subheading: String = "start",
    var description: String = "start",
    var theme: String = "start",
    var name: String = "id",
    var news : String = "news",
    var donations: List<Donation>? = null

)