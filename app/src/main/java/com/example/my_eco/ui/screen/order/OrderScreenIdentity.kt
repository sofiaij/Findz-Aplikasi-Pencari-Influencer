package com.example.my_eco.ui.screen.order

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.eclipse.findz.logic.registerUserLogic
import com.example.my_eco.ui.component.CircleStep
import com.example.my_eco.ui.component.CustomTextField
import com.example.my_eco.ui.component.DataInputField
import com.example.my_eco.ui.component.PageHeader

import com.example.my_eco.ui.screen.chat.ChatViewModel
import com.example.my_eco.ui.theme.soraFontFamily

@SuppressLint("UnrememberedMutableState")
@Composable
fun OrderScreenIdentity(
    navController: NavController,
    usernameInflu: String,
    influId: String,
    onNextClick: () -> Unit,
    userCurrentId: String,
    viewModel: OrderViewModel = hiltViewModel(),
) {
    val phoneNumber by viewModel.phoneNumber.collectAsState()
    val productOrService by viewModel.productOrService.collectAsState()
    val location by viewModel.location.collectAsState()
    val instagramAccount by viewModel.instagramAccount.collectAsState()
    val tiktokAccount by viewModel.tiktokAccount.collectAsState()

    // Validasi formulir dengan logika isNextEnabled
    val isNextEnabled = remember(
        phoneNumber,
        productOrService,
        location,
        instagramAccount,
        tiktokAccount
    ) {
        phoneNumber.isNotEmpty() &&
                productOrService.isNotEmpty() &&
                location.isNotEmpty() &&
                instagramAccount.isNotEmpty() &&
                tiktokAccount.isNotEmpty()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Header
            PageHeader(
                title = "Pemesanan",
                onBackClick = { navController.popBackStack() },
                bg = Color.White,
                txtColor = Color.Black,
                color = Color.Black
            )
            // Stepper
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircleStep(number = 1, isActive = true)
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(2.dp)
                        .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
                )
                CircleStep(number = 2, isActive = false)
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .height(2.dp)
                        .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
                )
                CircleStep(number = 3, isActive = false)
            }

            // Form
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                DataInputField(
                    name = usernameInflu,
                    onNameChange = { viewModel.updateInfluencerName(it) },
                    modifier = Modifier.padding(vertical = 8.dp),
                    label = "Nama Influencer",
                    enabledCondtion = false,

                )
                DataInputField(
                    label = "Kode",
                    name = userCurrentId,
                    onNameChange = { viewModel.updateCustomerName(it)  },
                    modifier = Modifier.padding(vertical = 8.dp),
                            enabledCondtion = false,
                )
                DataInputField(
                    label = "Nomor Hp",
                    name = phoneNumber,
                    onNameChange = { viewModel.updatePhoneNumber(it)},
                    modifier = Modifier.padding(vertical = 8.dp),
                    enabledCondtion = true,
                )
                DataInputField(
                    label = "Produk/layanan yang akan diiklankan",
                    name = productOrService,
                    onNameChange = { viewModel.updateProductOrService(it) },
                    modifier = Modifier.padding(vertical = 8.dp),
                    enabledCondtion = true,
                )
                DataInputField(
                    label = "Lokasi",
                    name = location,
                    onNameChange = { viewModel.updateLocation(it) },
                    modifier = Modifier.padding(vertical = 8.dp),
                    enabledCondtion = true,
                )
                DataInputField(
                    label = "Akun Instagram",
                    name = instagramAccount,
                    onNameChange = { viewModel.updateInstagramAccount(it)},
                    modifier = Modifier.padding(vertical = 8.dp),
                    enabledCondtion = true,
                )
                DataInputField(
                    label = "Akun TikTok",
                    name = tiktokAccount,
                    onNameChange = { viewModel.updateTiktokAccount(it) },
                    modifier = Modifier.padding(vertical = 8.dp),
                    enabledCondtion = true,
                )
            }

            Spacer(modifier = Modifier.height(45.dp))

            // Button
        }
        Button(
            onClick =
                onNextClick
            ,

            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(12.dp)
                .height(56.dp),
            enabled = isNextEnabled,
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




