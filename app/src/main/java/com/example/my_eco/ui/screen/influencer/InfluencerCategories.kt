package com.example.my_eco.ui.screen.influencer

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text as Text1
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InfluencerCategories() {
    // Menyusun kategori dengan horizontal scrolling
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()) // Agar bisa scroll horizontally
    ) {
        // Kategori 1
        CategoryButton(text = "OOTD")

        // Kategori 2
        CategoryButton(text = "Fashion Blogger")

        // Kategori 3
        CategoryButton(text = "Fashion Inspo")

        // Kategori 4
        CategoryButton(text = "Fashion Insta")
    }
}

@Composable
fun CategoryButton(text: String) {
    Button(
        onClick = { /* Handle click */ },
        modifier = Modifier
            .padding(4.dp) // Memberikan jarak antar tombol
            .height(50.dp) // Tentukan tinggi tombol
            .clip(RoundedCornerShape(25.dp)) // Sudut melengkung
            .border(2.dp, Color(0xFF625AFE), RoundedCornerShape(25.dp)), // Border ungu
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent // Mengatur warna latar belakang transparan
        )
    ) {
        // Teks kategori di dalam tombol
        Text1(
            text = text,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                color = Color(0xFF625AFE) // Warna teks ungu
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInfluencerCategories() {
    InfluencerCategories()
}
