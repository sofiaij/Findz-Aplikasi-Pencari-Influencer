package com.example.my_eco.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.my_eco.R
import com.example.my_eco.ui.theme.soraFontFamily


@Composable
fun RegisterScreen(navController: NavController) {
    var selectedText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.SpaceBetween, // Mengatur elemen untuk ada di antara dengan ruang
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Bagian pertama (tengah)
            Column(
                modifier = Modifier.weight(1f), // Memberikan ruang kosong untuk menjaga elemen lainnya tetap di tengah
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.findz_logo_horizontal),
                    contentDescription = "Logo Horizontal",
                    modifier = Modifier.size(200.dp)
                )
                Text(
                    text = "Selamat datang!",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp,
                    color = Color(0xFF716565),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Anda Seorang Influencer atau Pemilik UMKM?",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp,
                    color = Color(0xFF716565),
                )
                Spacer(modifier = Modifier.height(4.dp))
                DropdownTextField(selectedText = selectedText, onSelectedTextChange = {selectedText = it})
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(bottom = 28.dp) // Optional: untuk memberi jarak dengan bawah layar
            ) {
                Button(
                    onClick = {
                        when (selectedText) {
                            "Influencer" -> navController.navigate("registerinfluencer")
                            "Pemilik UMKM" -> navController.navigate("registerumkm")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth() // Membuat Button lebih lebar
                        .padding(horizontal = 24.dp)
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF625AFE)
                    )
                ) {
                    Text(
                        text = "Selanjutnya",
                        fontFamily = soraFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                }

                Spacer(modifier = Modifier.height(1.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Sudah punya akun?",
                        fontFamily = soraFontFamily,
                        fontWeight = FontWeight.Black,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(
                            text = "Masuk",
                            fontFamily = soraFontFamily,
                            fontWeight = FontWeight.Black,
                            fontSize = 12.sp,
                            color = Color(0xFF625AFE)
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownTextField(
    selectedText:String,
    onSelectedTextChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Influencer", "Pemilik UMKM")

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            value = selectedText,
            onValueChange = { },
            label = {
                Text(
                    "Pilih sebagai apa anda?",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = Color(0xFFD4D4D7)
                )
            },
            modifier = Modifier
                .menuAnchor() // Menambahkan modifier untuk anchor menu dropdown
                .border(1.dp, Color.Gray, shape = RoundedCornerShape(24.dp))
                .height(56.dp)
                .padding(horizontal = 28.dp),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            readOnly = true, // Agar TextField hanya bisa dipilih dari dropdown
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, // Background transparan
                disabledTextColor = Color(0xFFD4D4D7), // Warna teks saat disabled
                focusedIndicatorColor = Color.Transparent, // Warna border saat fokus
                unfocusedIndicatorColor = Color.Transparent, // Warna border saat tidak fokus
                focusedLabelColor = Color(0xFFD4D4D7), // Warna label saat fokus
                unfocusedLabelColor = Color(0xFFD4D4D7), // Warna label saat tidak fokus
                focusedTextColor = Color.Black
            ),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            Modifier.background(Color.White),
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            option,
                            color = if (selectedText == option) Color.Black else Color.Gray,
                            fontFamily = soraFontFamily,
                            fontWeight = if (selectedText == option) FontWeight.Black else FontWeight.Light,
                            fontSize = 12.sp
                        )
                    },
                    onClick = {
                        onSelectedTextChange(option)
                        expanded = false
                    },
                )
            }
        }
    }
}





