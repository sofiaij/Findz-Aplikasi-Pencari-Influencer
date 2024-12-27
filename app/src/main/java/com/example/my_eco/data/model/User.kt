package com.example.my_eco.data.model

data class User(
    val id: String = "",
    val name: String = "",
    val email: String = "",
    val role: String = "", // "UMKM" atau "Influencer"
    val phoneNumber: String = "",
    val businessField: String? = null, // Khusus UMKM
    val interestField: String? = null, // Khusus Influencer
    val instagramAccount: String? = null // Khusus Influencer
)


