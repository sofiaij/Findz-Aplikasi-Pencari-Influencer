package com.example.my_eco.ui.screen.order
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.my_eco.ui.component.PageHeader
import com.example.my_eco.ui.theme.soraFontFamily

@Composable
fun OrderPageItem(
    viewModel: OrderViewModel = hiltViewModel() ,
    navController: NavController,
    onUploadClick: () -> Unit,
    onNextClick: () -> Unit
) {
    // Data diambil dari ViewModel
    val priceAgreement by viewModel.priceAgreement.collectAsState()
    val feedCount by viewModel.feedCount.collectAsState()
    val storyCount by viewModel.storyCount.collectAsState()
    val tiktokCount by viewModel.tiktokCount.collectAsState()
    val youtubeCount by viewModel.youtubeCount.collectAsState()
    val additionalInfo by viewModel.additionalInfo.collectAsState()
    val startDate by viewModel.startDate.collectAsState()
    val endDate by viewModel.endDate.collectAsState()

    val isNextEnabled = priceAgreement.isNotEmpty() && startDate.isNotEmpty() && endDate.isNotEmpty()

    Box (
        modifier = Modifier
            .fillMaxSize()
    )
     {
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
                CircleStep(number = 3, isActive = false)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Kesepakatan Harga
           Column (
               modifier = Modifier
                   .weight(1f)
                   .verticalScroll(rememberScrollState())
                   .padding(horizontal = 16.dp)
           ) {
               DataInputField(
                   name = priceAgreement,
                   onNameChange = { viewModel.updatePriceAgreement(it) },
                   label = "Kesepakatan harga (total)",
                   modifier = Modifier.fillMaxWidth()
               )

               Spacer(modifier = Modifier.height(16.dp))

               // Upload File
               Box(
                   modifier = Modifier
                       .fillMaxWidth()
                       .height(120.dp)
                       .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp))
                       .clickable(onClick = onUploadClick),
                   contentAlignment = Alignment.Center
               ) {
                   Text(
                       text = "Klik untuk upload\nMaksimal 12 MB, format JPG/JPEG",
                       textAlign = TextAlign.Center,
                       color = MaterialTheme.colorScheme.onSurfaceVariant
                   )
               }

               Spacer(modifier = Modifier.height(16.dp))

               // Jumlah Postingan
               Text(text = "Jumlah postingan", style = MaterialTheme.typography.bodyMedium)
               Spacer(modifier = Modifier.height(8.dp))
               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.spacedBy(8.dp)
               ) {
                   DataInputField(
                       name = feedCount,
                       onNameChange = { viewModel.updateFeedCount(it) },
                       label = "Feed Instagram",
                       modifier = Modifier.weight(1f)
                   )
                   DataInputField(
                       name = storyCount,
                       onNameChange = { viewModel.updateStoryCount(it) },
                       label = "Story Instagram",
                       modifier = Modifier.weight(1f)
                   )
               }

               Spacer(modifier = Modifier.height(8.dp))
               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.spacedBy(8.dp)
               ) {
                   DataInputField(
                       name = tiktokCount,
                       onNameChange = { viewModel.updateTiktokCount(it) },
                       label = "Postingan TikTok",
                       modifier = Modifier.weight(1f)
                   )
                   DataInputField(
                       name = youtubeCount,
                       onNameChange = { viewModel.updateYoutubeCount(it) },
                       label = "Postingan Youtube",
                       modifier = Modifier.weight(1f)
                   )
               }

               Spacer(modifier = Modifier.height(16.dp))

               // Keterangan Tambahan
               DataInputField(
                   name = additionalInfo,
                   onNameChange = { viewModel.updateAdditionalInfo(it) },
                   label = "Keterangan tambahan",
                   modifier = Modifier.fillMaxWidth(),

                   )

               Spacer(modifier = Modifier.height(16.dp))

               // Tanggal Mulai dan Berakhir
               DataInputField(
                   name = startDate,
                   onNameChange = { viewModel.updateStartDate(it) },
                   label = "Tanggal mulai posting",
                   modifier = Modifier.padding(vertical = 8.dp)
               )
               DataInputField(
                   name = endDate,
                   onNameChange = { viewModel.updateEndDate(it) },
                   label = "Tanggal berakhir posting",
                   modifier = Modifier.padding(vertical = 8.dp)
               )

               Spacer(modifier = Modifier.height(100.dp))
           }

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
