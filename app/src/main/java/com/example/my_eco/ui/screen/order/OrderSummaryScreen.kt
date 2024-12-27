package com.example.my_eco.ui.screen.order


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.my_eco.ui.component.CircleStep
import com.example.my_eco.ui.component.DataInputField
import com.example.my_eco.ui.theme.soraFontFamily


@Composable
fun OrderSummaryScreen(
    viewModel: OrderViewModel = hiltViewModel() ,
    navController: NavController,
    onOrderClick: () -> Unit
) {
    // Mengambil data dari ViewModel
    val influencerName by viewModel.influencerName.collectAsState("Nanda Arsyinta")
    val customerName by viewModel.customerName.collectAsState("Me")
    val totalPosts by viewModel.feedCount.collectAsState("4")
    val influencerFee by viewModel.priceAgreement.collectAsState("200000")

    val total = influencerFee.toDoubleOrNull() ?: 0.0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Text(
                text = "Pemesanan",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(48.dp)) // Spacer for alignment
        }

        // Step Indicator
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
            CircleStep(number = 2, isActive = true)
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(2.dp)
                    .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
            )
            CircleStep(number = 3, isActive = true)
        }

        // Influencer and Customer Details
        DataInputField(
            name = influencerName,
            onNameChange = {viewModel.influencerName},
            label = "Nama Influencer",
            enabledCondtion = false,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        DataInputField(
            name = customerName,
            onNameChange = {viewModel.customerName},
            label = "Nama Pemesan",
            enabledCondtion = false,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        DataInputField(
            name = totalPosts,
            onNameChange = {viewModel.feedCount},
            label = "Total Postingan",
            enabledCondtion = false,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Payment Summary
        Text(
            text = "Jumlah yang dibayarkan",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            PaymentRow(label = "Biaya Influencer", amount = 200000.0)
            Spacer(modifier = Modifier.height(8.dp))
            PaymentRow(
                label = "Total",
                amount = total,
                isBold = true,
                textColor = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Order Button
        Button(
            onClick = {

            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF625AFE))
        ) {
            Text(
                text = "Pesan Sekarang ",
                fontFamily = soraFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun PaymentRow(label: String, amount: Double, isBold: Boolean = false, textColor: Color = Color.Black) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
            color = textColor

        )
        Text(
            text = "Rp.${"%,.0f".format(amount)}",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
            color = textColor
        )
    }
}
