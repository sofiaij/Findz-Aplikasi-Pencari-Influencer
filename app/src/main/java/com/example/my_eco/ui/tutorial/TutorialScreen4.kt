package com.example.my_eco.ui.tutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.my_eco.R
import com.example.my_eco.ui.theme.soraFontFamily

import com.example.my_eco.ui.tutorial.TutorialLine

@Composable
fun TutorialScreen4(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, bottom = 8.dp)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.panah_back) ,
                        contentDescription = "back",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { navController.navigate("tutorial3") }
                    )

                    Text(
                        text = "Lewati",
                        fontFamily = soraFontFamily,
                        fontWeight = FontWeight.Black,
                        fontSize = 12.sp,
                        color = Color(0xFFA6A39F),
                        modifier = Modifier.clickable { navController.navigate("home") }
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            TutorialLine(activeStep = 3)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                Text(
                    text = "4/5",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp,
                    color = Color(0xFF00BEFF)
                )
            }
            Box (
                modifier = Modifier
                    .height(400.dp)
                    .align(Alignment.CenterHorizontally),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tutor_bg),
                    contentDescription = "background tutorial",
                    modifier = Modifier.fillMaxSize()
                )
//                Image(
//                    painter = painterResource(id = R.drawable.tutor2),
//                    contentDescription = "tutor screen 1",
//                    modifier = Modifier
//                        .size(400.dp)
//                        .align(Alignment.Center)
//                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            )
            {
                Text(
                    text = "Findz Notify",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.Black,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier.padding(horizontal = 32.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.tutor4),
                    fontFamily = soraFontFamily,
                    fontSize = 12.sp,
                    color = Color(0xFF817E7B),
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigate("tutorial5") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF625AFE))
            ) {
                Text(
                    text = "Selanjutnya",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}