package com.example.kind1.data

data class Organisation(
    // on below line creating variables.
    var subheading: String = "",
    var description: String = "",
    var theme: String = "",
    var name: String = "",
    var news : String? = "",
    var link : String? = "",
    var donations: List<Donation>? = null

)