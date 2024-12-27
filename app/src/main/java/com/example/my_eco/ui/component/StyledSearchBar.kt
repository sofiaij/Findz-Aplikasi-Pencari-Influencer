package com.example.my_eco.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StyledSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = androidx.compose.ui.graphics.Color(0xFFEFEFEF), // Warna background abu-abu
                shape = androidx.compose.foundation.shape.RoundedCornerShape(50.dp) // Shape melingkar
            )
            .padding(horizontal = 16.dp, vertical = 8.dp), // Padding di dalam search bar
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search, // Ikon search bawaan
            contentDescription = "Search Icon",
            tint = androidx.compose.ui.graphics.Color(0xFFB0B0B0), // Warna ikon
            modifier = Modifier.size(20.dp) // Ukuran ikon
        )
        Spacer(modifier = Modifier.width(8.dp))
        BasicTextField(
            value = query,
            onValueChange = onQueryChange,
            singleLine = true,
            textStyle = androidx.compose.ui.text.TextStyle(
                color = androidx.compose.ui.graphics.Color.Gray, // Warna teks
                fontSize = 16.sp // Ukuran teks
            ),
            decorationBox = { innerTextField ->
                if (query.isEmpty()) {
                    Text(
                        text = "Cari",
                        color = androidx.compose.ui.graphics.Color(0xFFB0B0B0), // Placeholder warna abu
                        fontSize = 16.sp
                    )
                }
                innerTextField()
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}
