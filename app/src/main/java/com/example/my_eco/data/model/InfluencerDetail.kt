package com.example.my_eco.data.model

data class InfluencerDetail(
    val name: String,
    val profilePic: Int? = null,
    val rating: Float,
    val category: String,
    val instagramFollowers: Int,
    val tiktokFollowers: Int
)