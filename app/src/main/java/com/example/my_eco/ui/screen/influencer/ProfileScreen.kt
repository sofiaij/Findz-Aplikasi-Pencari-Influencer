package com.example.my_eco.ui.screen.influencer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_eco.R

@Composable
fun ProfileScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background (gambar background di atas)
        Image(
            painter = painterResource(id = R.drawable.background_image),
            contentDescription = "Background",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.TopCenter)
        )

        // Profile Picture dan info di bawah
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 220.dp),  // Posisi di bawah background
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Picture
            Image(
                painter = painterResource(id = R.drawable.profile_picture),  // Ganti dengan ID gambar profile
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)  // Ukuran gambar profile
                    .clip(CircleShape)  // Membuat gambar menjadi bentuk bulat
                    .background(Color.Gray)  // Background abu-abu di sekitar gambar
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Box berwarna ungu untuk nama dan pekerjaan
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF6A1B9A))  // Warna ungu
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "John Doe",  // Ganti dengan nama
                        style = TextStyle(color = Color.White, fontSize = 20.sp)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Software Developer",  // Ganti dengan pekerjaan
                        style = TextStyle(color = Color.White, fontSize = 16.sp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileScreen()
}
