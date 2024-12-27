package com.example.my_eco.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PageHeader(
    title: String,
    onBackClick: () -> Unit,
    color: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.onSecondary,
    bg: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primary,
    txtColor :androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.onSecondary,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(bg)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back" ,
                tint = color
            )
        }
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            color = txtColor,
            fontWeight = FontWeight.Bold
            )
        Spacer(modifier = Modifier.width(48.dp)) // Spacer for alignment
    }
}
