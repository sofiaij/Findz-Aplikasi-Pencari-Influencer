package com.example.my_eco.ui.screen.influencer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.example.my_eco.R

@Composable
fun InfluencerHeader(imageResId: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Enable vertical scrolling
    ) {
        // Gambar influencer sebagai latar belakang
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Influencer Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp), // Tinggi gambar
            contentScale = ContentScale.Crop // Gambar di-crop agar memenuhi lebar
        )

        // Tombol Back di pojok kiri atas
        IconButton(
            onClick = { /* Handle back action here */ },
            modifier = Modifier
                .size(70.dp)
                .padding(16.dp)
                .align(Alignment.TopStart) // Posisi tombol di pojok kiri atas
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }

        // Konten lainnya di bawah gambar
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomStart)
                .padding(top = 300.dp) // Konten dimulai setelah gambar
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Nama influencer dan rating
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Nanda Arsyinta",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = MaterialTheme.typography.headlineSmall.fontSize
                        )
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "5.0",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = MaterialTheme.typography.headlineSmall.fontSize
                            ),
                            modifier = Modifier.padding(end = 4.dp)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = "Star Icon",
                            tint = Color.Yellow,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Fashion",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.titleSmall.fontSize
                    ),
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Ikon Instagram dan TikTok
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_instagram),
                        contentDescription = "Instagram Icon",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "4.1 jt",
                        style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_tiktok),
                        contentDescription = "TikTok Icon",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "3.2 jt",
                        style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Tambahan lainnya (Kategori, Grafik, dll.)
            InfluencerCategories()
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Permintaan endorse tahun ini",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            BarChart()

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listOf(
                    R.drawable.image1,
                    R.drawable.image2,
                    R.drawable.image3,
                    R.drawable.image4
                )) { imageResId ->
                    Box(
                        modifier = Modifier
                            .width(120.dp)
                            .height(200.dp)
                            .clip(RoundedCornerShape(8.dp))
                    ) {
                        Image(
                            painter = painterResource(id = imageResId),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Play Button",
                            tint = Color.White,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(40.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Penilaian",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            ReviewsSection(
                reviews = listOf(
                    Review(
                        imageResId = R.drawable.profile1,
                        name = "Dinda Rizkika",
                        date = "11 hari yang lalu",
                        rating = 5,
                        comment = "Kak Nanda selalu bekerja dengan sangat profesional. Hasilnya selalu memuaskan! Orderan langsung numpuk!"
                    ),
                    Review(
                        imageResId = R.drawable.profile1,
                        name = "Fitria Ayu",
                        date = "20 hari yang lalu",
                        rating = 4,
                        comment = "Hasil endorse sangat bagus. Namun, pengiriman materi agak lambat."
                    )
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInfluencerHeader() {
    InfluencerHeader(imageResId = R.drawable.influencer_image)
}
