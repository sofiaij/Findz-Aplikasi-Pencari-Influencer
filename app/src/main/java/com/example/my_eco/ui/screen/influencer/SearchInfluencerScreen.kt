package com.example.my_eco.ui.screen.influencer

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.my_eco.R
import com.example.my_eco.data.model.Influencer

@Composable
fun SearchInfluencerScreen(navController: NavHostController) {
    // State untuk query pencarian dan daftar riwayat
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    var recentSearches by remember { mutableStateOf(listOf("Raffi Ahmad", "Nagita Slavina", "Tasya Farasya","Nanda arsyinta")) }
    var isExpanded by remember { mutableStateOf(false) }
    var influencers by remember { mutableStateOf<List<Influencer>>(emptyList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Baris untuk kolom pencarian
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Tombol Kembali
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFF625AFE)
                )
            }

            // Kolom Pencarian (Menggunakan BasicTextField)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
                    .background(Color.White, shape = RoundedCornerShape(50.dp))
                    .border(1.dp, Color(0xFF625AFE), RoundedCornerShape(50.dp))
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color(0xFF625AFE),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    BasicTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(
                            fontSize = 16.sp,
                            color = Color.Black
                        ),
                        decorationBox = { innerTextField ->
                            if (searchQuery.text.isEmpty()) {
                                Text(
                                    text = "Cari",
                                    style = LocalTextStyle.current.copy(
                                        fontSize = 16.sp,
                                        color = Color.Gray
                                    )
                                )
                            }
                            innerTextField()
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol "Hapus Semua"
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = { recentSearches = emptyList() }) {
                Text(
                    text = "Hapus Semua",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.Black
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Daftar Riwayat Pencarian
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            recentSearches.forEach { search ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = search,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Black,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.clickable {
                            if (search == "Nanda Arsyinta") {
                                navController.navigate("influencer_card/Nanda Arsyinta")
                            }
                        }
                    )
                    IconButton(onClick = { recentSearches = recentSearches.filter { it != search } }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Remove",
                            tint = Color.Black
                        )
                    }
                }
                Divider(color = Color.LightGray, thickness = 1.dp)
            }

            // Tombol "Lihat Lainnya"
            TextButton(
                onClick = {
                    isExpanded = !isExpanded
                    if (isExpanded) {
                        influencers = listOf(
                            Influencer(
                                name = "Nanda Arsyinta",
                                category = "Fashion",
                                imageRes = R.drawable.influencer_image,
                                rating = 5.0f,
                                followersInstagram = "4.1 jt",
                                followersTiktok = "3.2 jt"
                            )
                        )
                    } else {
                        influencers = emptyList()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (isExpanded) "Lebih Sedikit" else "Lebih Banyak",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.Gray
                    )
                )
            }

            // Menampilkan Influencers
            influencers.forEach { influencer ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = influencer.name,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp
                        ),
                        modifier = Modifier.clickable {
                            navController.navigate("influencer_card/${influencer.name}")
                        }
                    )
                    IconButton(onClick = {
                        navController.navigate("influencer_card/${influencer.name}")
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Detail",
                            tint = Color.Black
                        )
                    }
                }
                Divider(color = Color.LightGray, thickness = 1.dp)
            }
        }
    }
}