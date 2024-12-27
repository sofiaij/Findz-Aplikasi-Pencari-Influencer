package com.example.my_eco.data.model

data class Message(
    val senderId: String = "",
    val text: String = "",
    val timestamp: Long = System.currentTimeMillis()
)