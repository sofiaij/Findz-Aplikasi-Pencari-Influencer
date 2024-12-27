package com.example.my_eco.ui.screen.influencer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BarChart() {
    val values = listOf(20, 40, 80, 30, 50, 70, 100)
    val months = listOf("Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agt")
    val maxValue = values.maxOrNull() ?: 100
    val steps = 5

    Column(Modifier.fillMaxWidth().padding(16.dp)) {
        //Text("Permintaan endorse tahun ini", style = MaterialTheme.typography.titleMedium)

        // Area Grafik
        Box(Modifier.fillMaxWidth().height(150.dp)) {
            val stepHeight = 150.dp / steps

            // Garis Koordinat Horizontal
            (0..steps).forEach { i ->
                val yValue = (maxValue / steps) * i
                Row(
                    Modifier.fillMaxWidth().padding(top = 150.dp - stepHeight * i),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("$yValue", style = MaterialTheme.typography.bodySmall)
                    Box(Modifier.fillMaxWidth().height(1.dp).background(Color.LightGray))
                }
            }

            // Batang Grafik
            Row(
                Modifier.fillMaxWidth().align(Alignment.BottomStart),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                values.forEachIndexed { index, value ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Spacer(modifier = Modifier.weight(1f)) // Isi ruang kosong di atas batang
                        Box(
                            Modifier
                                .width(16.dp)
                                .height((value.toFloat() / maxValue * 150).dp)
                                .background(Color.Blue, RoundedCornerShape(4.dp))
                        )
                        Text(months[index], style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }

        // Sumbu X
        Box(Modifier.fillMaxWidth().height(1.dp).background(Color.Black))
    }
}