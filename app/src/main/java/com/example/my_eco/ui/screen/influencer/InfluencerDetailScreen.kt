package com.example.findz

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.navigation.NavController

@Composable
fun InfluencerDetailScreen(navController: NavController, influencerName: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Tombol Kembali
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF625AFE)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Menampilkan Nama Artis
        Text(
            text = "Detail Influencer: $influencerName",
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black
        )

        // Tambahkan informasi lebih lanjut tentang artis
        // Misalnya bisa menambahkan foto, bio, dll.
        Text(
            text = "Informasi lebih lanjut akan ditampilkan di sini.",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        Button(onClick = {navController.navigate("influencer_card_header/Nanda Arsyinta")}) {
            Text(text = "Tampilkan")
        }
    }
}

