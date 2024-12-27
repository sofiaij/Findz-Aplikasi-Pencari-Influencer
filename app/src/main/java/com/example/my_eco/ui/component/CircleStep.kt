package com.example.my_eco.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable
fun CircleStep(number: Int, isActive: Boolean) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(
                color = if (isActive) Color(0xFF625AFE) else MaterialTheme.colorScheme.surface,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            color = if (isActive) Color.White else MaterialTheme.colorScheme.onSurface
        )
    }
}