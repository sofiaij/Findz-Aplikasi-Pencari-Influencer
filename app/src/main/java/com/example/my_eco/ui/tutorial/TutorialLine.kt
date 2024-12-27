package com.example.my_eco.ui.tutorial

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TutorialLine(activeStep: Int) {
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        repeat(5) { index ->
            Box(
                modifier = Modifier
                    .width(62.dp)
                    .height(8.dp)
                    .border(1.dp, Color.White, shape = RoundedCornerShape(48.dp))
                    .background(
                        color = if (index == activeStep) Color(0xFF00BEFF) else Color(0xFFB2DEFF),
                        shape = RoundedCornerShape(48.dp)
                    )

            )

        }
    }
}