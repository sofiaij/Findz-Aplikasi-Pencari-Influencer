package com.example.my_eco.data.model

data class RecentMessage(
    val text: String,
    val timestamp: Long,
    val unreadCount: Int = 0
)
