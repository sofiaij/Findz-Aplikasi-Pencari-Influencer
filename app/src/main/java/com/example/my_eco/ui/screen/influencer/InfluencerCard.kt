package com.example.findz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_eco.R
import com.example.my_eco.data.model.Influencer

@Composable
fun InfluencerCard(influencer: Influencer) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {
        // Gambar Influencer
        Image(
            painter = painterResource(id = influencer.imageRes),
            contentDescription = influencer.name,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(12.dp))

        // Detail Influencer
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = influencer.name,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            Text(
                text = influencer.category,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = influencer.followersInstagram,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(end = 4.dp)
                )
                Text(
                    text = influencer.followersTiktok,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

        IconButton(onClick = { /* Navigate to detail page */ }) {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Detail",
                tint = Color(0xFF625AFE)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInfluencerCard() {
    InfluencerCard(
        influencer = Influencer(
            name = "Nanda Arsyinta",
            category = "Fashion",
            imageRes = R.drawable.influencer_image,
            rating = 5.0f,
            followersInstagram = "4.1 jt",
            followersTiktok = "3.2 jt"
        )
    )
}
