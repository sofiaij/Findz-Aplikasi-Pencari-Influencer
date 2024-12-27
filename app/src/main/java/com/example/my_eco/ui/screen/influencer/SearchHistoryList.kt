package com.example.my_eco.ui.screen.influencer

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchHistoryList(recentSearches: List<String>, onRemove: (String) -> Unit, onExpand: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // Menampilkan daftar riwayat pencarian
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
                        color = Color.Black
                    )
                )
                IconButton(onClick = { onRemove(search) }) {
                    Icon(
                        imageVector = Icons.Default.Close, // Ikon "x"
                        contentDescription = "Remove",
                        tint = Color.Black
                    )
                }
            }
            Divider(color = Color.LightGray, thickness = 1.dp) // Garis pemisah
        }

        // Tombol "Lihat Lainnya"
        TextButton(
            onClick = { onExpand() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Lihat Lainnya",
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.Gray
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchHistoryList() {
    var searches by remember { mutableStateOf(listOf("Raffi Ahmad", "Nagita Slavina", "Tasya Farasya")) }
    var isExpanded by remember { mutableStateOf(false) }

    SearchHistoryList(
        recentSearches = if (isExpanded) searches + "Lihat Semua" else searches,
        onRemove = { search -> searches = searches.filter { it != search } },
        onExpand = { isExpanded = !isExpanded }
    )
}
