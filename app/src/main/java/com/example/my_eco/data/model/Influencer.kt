package com.example.my_eco.data.model

data class Influencer(
    val name: String = "",
    val profilePicUrl: Int? = null, // URL atau path ke gambar profil
    val rating: Float = 0f, // Rating influencer, bisa dari 1 sampai 5
    val category: String = "",
    val imageRes: Int = 0,
    val followersInstagram: String = "0",
    val followersTiktok: String = "0"
)
