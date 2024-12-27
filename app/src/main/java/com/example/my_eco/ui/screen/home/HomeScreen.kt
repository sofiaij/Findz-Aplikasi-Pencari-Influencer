package com.example.my_eco.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import com.example.my_eco.data.model.InfluencerDetail
import com.example.my_eco.R
import com.example.my_eco.data.model.Influencer
import com.example.my_eco.ui.theme.soraFontFamily

@Composable
fun HomeScreen(
    onNavigateToUser: () -> Unit,
    onNavigateToUserList: () -> Unit,
    onNavigateToOrderIndent: () -> Unit,
    onNavigateToInflu: () -> Unit
) {

    var selectedItem = 0
    val influencerDetails = listOf(
        InfluencerDetail("Nanda Arsyinta", R.drawable.rachel, 4.5f, "Fashion", 100, 5000),
        InfluencerDetail("Ria Ricis", R.drawable.rachel, 4.8f, "Kecantikan",  500, 2000),
        InfluencerDetail("Rachel Vennya", R.drawable.rachel, 4.3f, "Lifestyle",  2000, 1000),
        InfluencerDetail("Lina", R.drawable.rachel, 4.9f, "Fashion",  150, 30),
        InfluencerDetail("Avan the Love", R.drawable.rachel, 4.7f, "Music",1200, 800)
    )



    Column (
    ) {
        // Navigasi ke User Profile
//        Button(
//            onClick = { onNavigateToUser() },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//        ) {
//            Text("Go to User Profile")
//        }
//
//        // Navigasi ke Daftar Pengguna
//        Button(
//            onClick = { onNavigateToUserList() },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//        ) {
//            Text("Start Chat")
//        }
//
//        // Navigasi ke Daftar Pengguna
//        Button(
//            onClick = { onNavigateToOrderIndent() },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//        ) {
//            Text("Order")
//        }
        Box() {
            Box(
                modifier = Modifier.fillMaxWidth().height(200.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.home_header),
                    contentDescription = "Header HomeScreen UMKM",
                    modifier = Modifier.size(500.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Halo, Nama (bisa terpisah ke bawah jika panjang)
                        Text(
                            text = "Halo, ",
                            fontFamily = soraFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.White,
                            maxLines = 1, // Membatasi agar text tidak melebar
                            overflow = TextOverflow.Ellipsis, // Jika nama terlalu panjang, akan dipotong
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(16.dp))

                        // Chat Icon Button
                        IconButton(
                            onClick = { onNavigateToUserList()},
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.chat_icon),
                                contentDescription = "Chat",
                                tint = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))

                        // Notification Icon Button
                        IconButton(
                            onClick = { onNavigateToOrderIndent() },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.notif_icon),
                                contentDescription = "Notif",
                                tint = Color.White
                            )
                        }
                    }
                    Text(
                        text = "Temukan influencer terbaikmu!",
                        fontFamily = soraFontFamily,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        //Cari
                        Box(
                            modifier = Modifier
                                .width(300.dp)
                                .height(52.dp)
                                .clip(RoundedCornerShape(28.dp)) // Membuat box mengikuti bentuk rounded
                                .background(Color.White) // Background putih hanya di dalam rounded
                        ) {
                            Button(
                                onClick = { onNavigateToInflu() },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp)
                                    .background(Color.White), // Tinggi disesuaikan agar mirip dengan TextField
                                shape = RoundedCornerShape(32.dp), // Menjaga bentuk rounded
                                colors = ButtonColors(containerColor = Color.White, Color.Gray, Color.Black, Color.Blue)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.search_icon),
                                        contentDescription = "Search",
                                        tint = Color(0xFFABADB0),
                                        modifier = Modifier
                                            .size(32.dp)
                                            .padding(start = 8.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "Cari",
                                        fontFamily = soraFontFamily,
                                        fontSize = 12.sp,
                                        color = Color(0xFFABADB0),
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }

                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        //Filter
                        IconButton(
                            onClick = {onNavigateToUser()},
                            modifier = Modifier.size(36.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.filter_icon),
                                contentDescription = "Filter",
                                tint = Color.Unspecified
                            )
                        }
                    }
                }
            }
        }
        LazyColumn (
            modifier = Modifier
                .background(Color.White)
                .height(580.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            item {
                Text(
                    text = "Influencer Pilihan Minggu Ini",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Cek profil dan kolaborasi sekarang!",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Black,
                    fontSize = 12.sp
                )
            }
            item { Spacer(modifier = Modifier.height(4.dp)) }
            item {
                InfluencerRow()
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item {
                Text(
                    text = "Kategori",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ) }
            item {
                CategoryRow()
            }
            item { Spacer(modifier = Modifier.height(12.dp)) }
            item {
                Text(
                    text = "Untukmu",
                    fontFamily = soraFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
            items(influencerDetails) {influencer ->
                InfluencerItem(influencer)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
        ) {
            BottomNavigationBar(selectedItem) { selectedItem = it }
        }
    }
}


@Composable //Data Dummy
fun InfluencerRow() {
    // Daftar influencer sebagai contoh data (nama, foto, dan rating)
    val influencers = listOf(
        Influencer("Nanda Arsyinta", R.drawable.tasya_profil, 4.5f),
        Influencer("Ria Ricis", R.drawable.tasya_profil, 4.8f),
        Influencer("Rachel Vennya", R.drawable.tasya_profil, 4.3f),
        Influencer("Lina", R.drawable.tasya_profil, 4.9f),
        Influencer("Avan the Love", R.drawable.tasya_profil, 4.7f)
    )

    LazyRow (
        modifier = Modifier
            .fillMaxWidth()
//            .padding(16.dp)
    ){
        items(influencers) {influencer ->
            InfluencerCard(influencer)
        }
    }
}

@Composable
fun InfluencerCard(influencer: Influencer) {
    // Card untuk setiap influencer
    Card(
        modifier = Modifier
            .width(150.dp) // Lebar card
            .height(180.dp)
            .padding(end = 8.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { /*Todo*/ }, // Spasi antar influencer
        shape = RoundedCornerShape(12.dp), // Sudut melengkung
        elevation = CardDefaults.outlinedCardElevation(14.dp), // Shadow untuk card
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFDFD)) // Warna latar belakang biru
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(2.dp, Color(0xFFF0F0F0), RoundedCornerShape(12.dp))
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp), // Padding di dalam card
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Foto profil influencer (bisa berupa gambar default kalau tidak ada foto)
                influencer.profilePicUrl?.let { painterResource(id = it) }?.let {
                    Image(
                        painter = it,
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(60.dp) // Ukuran foto profil
                            .clip(CircleShape), // Membuat foto profil berbentuk bulat
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Nama influencer
                Text(
                    text = influencer.name,
                    fontFamily = soraFontFamily,
                    fontSize = 14.sp,
                    color = Color(0xFF055B9E)
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Rating influencer
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "${influencer.rating}",
                        fontFamily = soraFontFamily,
                        fontSize = 12.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        painter = painterResource(R.drawable.star),
                        contentDescription = "Rating",
                        tint = Color(0xFFFFD141),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryRow() {
    // Daftar kategori langsung dalam bentuk list
    val categories = listOf(
        "Kecantikan" to R.drawable.fashion,
        "Fashion" to R.drawable.fashion,
        "FnB" to R.drawable.fnb,
        "Elektronik" to R.drawable.fnb,
        "Perjalanan dan Pariwisata" to R.drawable.fnb,
        "Jasa" to R.drawable.fashion,
        "Rumah Tangga" to R.drawable.fnb
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(categories) { category ->
            CategoryCard(categoryName = category.first, categoryImage = category.second)
        }
    }
}

@Composable
fun CategoryCard(categoryName: String, categoryImage: Int) {
    // Card untuk setiap kategori
    Card(
        modifier = Modifier
            .width(150.dp) // Lebar card
            .padding(end = 8.dp) // Spasi antar card
            .height(58.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { /*Todo*/ },
//        elevation = CardDefaults.outlinedCardElevation(4.dp), // Shadow untuk card
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = painterResource(id = categoryImage),
                contentDescription = categoryName,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            // Teks kategori di tengah card
            Text(
                text = categoryName,
                fontFamily = soraFontFamily,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center) // Menempatkan teks di tengah card
                    .padding(4.dp) // Memberikan jarak agar teks tidak terlalu dekat dengan tepi card
            )
        }
    }
}

@Composable
fun InfluencerItem(influencerDetail: InfluencerDetail) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp), // Memberikan jarak antar item
        shape = RoundedCornerShape(12.dp), // Sudut card melengkung
    ) {
        Box(
            modifier = Modifier.height(150.dp).background(Color.White)
        ) {
            Row {
                //Foto profil segede gaban
                influencerDetail.profilePic?.let { painterResource(id = it) }?.let {
                    Image(
                        painter = it,
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .fillMaxHeight()
                            .clip(RectangleShape),
                        contentScale = ContentScale.FillHeight
                    )
                    Column (
                        modifier = Modifier
                            .width(175.dp)
                            .fillMaxHeight()
                            .padding(start = 8.dp, top = 16.dp)
                    ) {
                        Text(
                            text = influencerDetail.name,
                            fontFamily = soraFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                        Text(
                            text = influencerDetail.category,
                            fontFamily = soraFontFamily,
                            fontSize = 12.sp,
                            color = Color(0xFF909090)
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(R.drawable.instagram_logo),
                                contentDescription = "insagram logo",
                                modifier = Modifier.size(24.dp)
                            )
                            Text(
                                text = influencerDetail.instagramFollowers.toString() + "k",
                                fontFamily = soraFontFamily,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Image(
                                painter = painterResource(R.drawable.tiktok_logo),
                                contentDescription = "tiktok logo",
                                modifier = Modifier.size(24.dp)
                            )
                            Text(
                                text = influencerDetail.tiktokFollowers.toString() + "k",
                                fontFamily = soraFontFamily,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }

                    }
                    Column (
                        modifier = Modifier.fillMaxHeight().width(56.dp).padding(vertical = 20.dp).padding(end = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ){
                        // Rating influencer
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "${influencerDetail.rating}",
                                fontFamily = soraFontFamily,
                                fontSize = 12.sp,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                painter = painterResource(R.drawable.star), // Ikon bintang untuk rating
                                contentDescription = "Rating",
                                tint = Color(0xFFFFD141),
                                modifier = Modifier.size(16.dp)
                            )
                        }
                        Icon(
                            painter = painterResource(R.drawable.next_button),
                            contentDescription = "next",
                            tint = Color.Unspecified,
                            modifier = Modifier
                                .size(40.dp)
                                .clickable { /*Todo*/ }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar (selectedItem: Int, onItemSelected: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White)
            .border(1.dp, Color(0xFFEBEBEB), RoundedCornerShape(8.dp)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem(
            icon = painterResource(id = R.drawable.home_icon),
            label = "Home",
            isSelected = selectedItem == 0,
            onClick = { /*Todo*/ }
        )
        BottomNavItem(
            icon = painterResource(id = R.drawable.pesanan_icon),
            label = "Search",
            isSelected = selectedItem == 1,
            onClick = { /*Todo*/ }
        )
        BottomNavItem(
            icon = painterResource(id = R.drawable.profil_icon),
            label = "Profile",
            isSelected = selectedItem == 2,
            onClick = { /*Todo*/ }
        )
    }
}

@Composable
fun BottomNavItem(
    icon: Painter,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
        Icon(
            painter = icon,
            contentDescription = label,
            tint = if (isSelected) Color(0xFF3F50E6) else Color(0xFFA3A7AB)
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = if (isSelected) Color.White else Color.Gray
        )
    }
}
