package com.example.my_eco.ui.screen.influencer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.my_eco.R

@Composable
fun ReviewsSection(reviews: List<Review>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        reviews.forEach { review ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                // Gambar profil
                Image(
                    painter = painterResource(id = review.imageResId),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(50)) // Gambar profil bulat
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    // Nama dan tanggal
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = review.name,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = review.date,
                            style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray)
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    // Rating dengan bintang
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        repeat(review.rating) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_star),
                                contentDescription = "Star",
                                tint = Color.Yellow,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Teks ulasan
                    Text(
                        text = review.comment,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

// Data model untuk ulasan
data class Review(
    val imageResId: Int,
    val name: String,
    val date: String,
    val rating: Int,
    val comment: String
)

// Preview untuk testing
@Preview(showBackground = true)
@Composable
fun PreviewReviewsSection() {
    val dummyReviews = listOf(
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
    ReviewsSection(reviews = dummyReviews)
}
