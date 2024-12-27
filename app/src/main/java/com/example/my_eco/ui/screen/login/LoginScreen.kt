package com.example.my_eco.ui.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.my_eco.R
import com.example.my_eco.data.network.auth.loginUser
import com.example.my_eco.ui.theme.soraFontFamily


@Composable
fun LoginScreen (navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.findz_logo_horizontal),
                contentDescription = "Logo Horizontal",
                modifier = Modifier.size(200.dp)
            )
            Text(
                text = "Selamat datang kembali!",
                fontFamily = soraFontFamily,
                fontWeight = FontWeight.Black,
                fontSize = 12.sp,
                color = Color(0xFF716565)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Masuk",
                fontFamily = soraFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            LoginForm(
                email = email,
                onEmailChange = { email = it},
                password = password,
                onPasswordChange = { password = it }
            )
            Spacer(modifier = Modifier.height(36.dp))
            // Button Login
            Button(
                onClick = {
                    loginUser(email, password, navController, onError = { errorMessage = it})
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF625AFE))
            ) {
                Text(
                    text = "Masuk",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LineWithText(text = "Atau")
            LoginWithGoogle()
            Spacer(modifier = Modifier.height(24.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "Belum punya akun?",
                    fontFamily = soraFontFamily,
                    fontSize = 12.sp,
                    color = Color.Black
                )
                TextButton(onClick = { navController.navigate("register") }) {
                    Text(
                        text = "Daftar",
                        fontFamily = soraFontFamily,
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color(0xFF625AFE)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginForm(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp) // Memberi jarak antar elemen
    ) {
        // Email
        Text(
            text = "Email",
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.Black,
            color = Color(0xFF62636B),
            fontSize = 12.sp
        )
        OutlinedTextField(
            value = email,
            onValueChange = onEmailChange,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(48.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF625AFE),
                unfocusedBorderColor = Color(0xFFD4D4D7)
            ),
            textStyle = TextStyle(
                fontFamily = soraFontFamily,
                fontWeight = FontWeight.Black,
                fontSize = 14.sp,
                color = Color.Black
            )
        )
        Text(text = "Kata Sandi",
            fontFamily = soraFontFamily,
            fontWeight = FontWeight.Black,
            color = Color(0xFF62636B),
            fontSize = 12.sp
        )
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(48.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF625AFE),
                unfocusedBorderColor = Color(0xFFD4D4D7)
            )
        )
    }
}

@Composable
fun LineWithText(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Garis di kiri
        Box(
            modifier = Modifier
                .weight(1f) // Menyesuaikan lebar dengan sisa ruang
                .padding(start = 32.dp)
                .height(1.dp) // Tinggi garis
                .background(Color(0xFFDBD9D9)) // Warna garis
        )
        // Teks di tengah
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color(0xFFB7B0B0)
        )
        // Garis di kanan
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(end = 32.dp)
                .height(1.dp)
                .background(Color(0xFFDBD9D9))
        )
    }
}

@Composable
fun LoginWithGoogle() {
    Button(
        onClick = { /*TODO: Implement login action*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(56.dp)
            .border(1.dp, color = Color(0xFF716565), shape = RoundedCornerShape(32.dp)),
        colors = ButtonDefaults.buttonColors(Color.White) // Transparan, karena border yang menjadi fokus
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Logo Google
            Image(
                painter = painterResource(id = R.drawable.google_logo),
                contentDescription = "Logo Google",
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(16.dp)) // Menyesuaikan jarak
            // Teks
            Text(
                text = "Masuk dengan Google",
                fontFamily = soraFontFamily,
                fontWeight = FontWeight.Black,
                color = Color(0xFF716565)
            )
        }
    }
}