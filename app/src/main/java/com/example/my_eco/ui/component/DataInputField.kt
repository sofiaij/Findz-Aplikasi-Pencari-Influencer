package com.example.my_eco.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_eco.ui.theme.soraFontFamily

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun DataInputField(
    name: String,
    onNameChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    enabledCondtion : Boolean = true,
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            enabled = enabledCondtion,
            label = {
                Text(
                    label,
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Black,
                    color = Color(0xFF62636B),
                    fontSize = 10.sp
                )
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(48.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF625AFE) ,
                unfocusedBorderColor = Color(0xFFD4D4D7)
            ),
            textStyle = TextStyle(
                fontFamily = soraFontFamily,
                fontWeight = FontWeight.Black,
                fontSize = 12.sp,
                color = Color.Black
            )

        )

        Spacer(modifier = Modifier.height(8.dp))
    }
}
